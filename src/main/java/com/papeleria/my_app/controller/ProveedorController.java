package com.papeleria.my_app.controller;

import com.papeleria.my_app.entity.Proveedor;
import com.papeleria.my_app.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // Mostrar listado de proveedores
    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.obtenerTodosLosProveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedor";
    }

    // Agregar proveedor
    @PostMapping("/proveedor")
    public String agregarProveedor(@RequestParam String nombre,
                                   @RequestParam(required = false) String telefono,
                                   @RequestParam(required = false) String email) {
        proveedorService.crearProveedor(nombre, telefono, email);
        return "redirect:/proveedores";
    }

    // Actualizar proveedor
    @PostMapping("/proveedor/actualizar")
    public String actualizarProveedor(@RequestParam Integer id,
                                      @RequestParam String nombre,
                                      @RequestParam(required = false) String telefono,
                                      @RequestParam(required = false) String email) {
        proveedorService.actualizarProveedor(id, nombre, telefono, email);
        return "redirect:/proveedores";
    }

    // Eliminar proveedor
    @PostMapping("/proveedor/eliminar")
    public String eliminarProveedor(@RequestParam Integer id) {
        proveedorService.eliminarProveedor(id);
        return "redirect:/proveedores";
    }
}