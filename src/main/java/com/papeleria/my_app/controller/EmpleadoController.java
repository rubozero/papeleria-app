package com.papeleria.my_app.controller;

import com.papeleria.my_app.entity.Empleado;
import com.papeleria.my_app.service.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // Mostrar listado de empleados
    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleado";
    }

    // Agregar empleado
    @PostMapping("/empleado")
    public String agregarEmpleado(@RequestParam String nombre,
                                  @RequestParam String turno) {
        empleadoService.crearEmpleado(nombre, turno);
        return "redirect:/empleados";
    }

    // Actualizar empleado
    @PostMapping("/empleado/actualizar")
    public String actualizarEmpleado(@RequestParam Integer id,
                                     @RequestParam String nombre,
                                     @RequestParam String turno) {
        empleadoService.actualizarEmpleado(id, nombre, turno);
        return "redirect:/empleados";
    }

    // Eliminar empleado
    @PostMapping("/empleado/eliminar")
    public String eliminarEmpleado(@RequestParam Integer id) {
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}