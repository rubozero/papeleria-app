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
    public String agregarVenta(@RequestParam("idEmpleado") Long idEmpleado,
                               @RequestParam("total") BigDecimal total) {
        ventaService.crearVenta(LocalDateTime.now(), idEmpleado, total);
        return "redirect:/ventas";
    }

    // Actualizar venta (no permite editar la fecha)
    @PostMapping("/venta/actualizar")
    public String actualizarVenta(@RequestParam("id") Long id,
                                  @RequestParam("idEmpleado") Long idEmpleado,
                                  @RequestParam("total") BigDecimal total) {
        ventaService.actualizarVentaSinFecha(id, idEmpleado, total);
        return "redirect:/ventas";
    }

    // Eliminar venta
    @PostMapping("/venta/eliminar")
    public String eliminarVenta(@RequestParam("id") Long id) {
        ventaService.eliminarVenta(id);
        return "redirect:/ventas";
    }
}