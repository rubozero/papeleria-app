package com.papeleria.my_app.controller;

import com.papeleria.my_app.entity.Venta;
import com.papeleria.my_app.entity.Empleado;
import com.papeleria.my_app.service.VentaService;
import com.papeleria.my_app.service.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class VentaController {

    private final VentaService ventaService;
    private final EmpleadoService empleadoService;

    public VentaController(VentaService ventaService, EmpleadoService empleadoService) {
        this.ventaService = ventaService;
        this.empleadoService = empleadoService;
    }

    // Mostrar listado de ventas
    @GetMapping("/ventas")
    public String listarVentas(Model model) {
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("ventas", ventas);
        model.addAttribute("empleados", empleados);
        return "venta";
    }

    // Agregar venta (sin pedir fecha, la asigna el backend)
    @PostMapping("/venta")
    public String agregarVenta(@RequestParam("idEmpleado") Integer idEmpleado,
                               @RequestParam("total") BigDecimal total) {
        ventaService.crearVenta(LocalDateTime.now(), idEmpleado, total);
        return "redirect:/ventas";
    }

    // Actualizar venta (no permite editar la fecha)
    @PostMapping("/venta/actualizar")
    public String actualizarVenta(@RequestParam("id") Integer id,
                                  @RequestParam("idEmpleado") Integer idEmpleado,
                                  @RequestParam("total") BigDecimal total) {
        ventaService.actualizarVentaSinFecha(id, idEmpleado, total);
        return "redirect:/ventas";
    }

    // Eliminar venta
    @PostMapping("/venta/eliminar")
    public String eliminarVenta(@RequestParam("id") Integer id) {
        ventaService.eliminarVenta(id);
        return "redirect:/ventas";
    }

    // Obtener ventas por empleado para empleados-ventas.html (devuelve solo las ventas y el empleado)
    @GetMapping("/ventas/empleado/{idEmpleado}")
    public String listarVentasPorEmpleado(@PathVariable Integer idEmpleado, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorId(idEmpleado);
        List<Venta> ventas = ventaService.obtenerVentasPorEmpleado(idEmpleado);
        model.addAttribute("empleado", empleado);
        model.addAttribute("ventas", ventas);
        return "empleados-ventas :: ventasEmpleadoModal";
    }

    @GetMapping("/empleados-ventas")
    public String mostrarEmpleadosVentas(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();
        Map<Integer, List<Venta>> ventasPorEmpleado = ventas.stream()
            .collect(Collectors.groupingBy(v -> v.getEmpleado().getIdEmpleado()));
        model.addAttribute("empleados", empleados);
        model.addAttribute("ventasPorEmpleado", ventasPorEmpleado);
        return "empleados-ventas";
    }
}