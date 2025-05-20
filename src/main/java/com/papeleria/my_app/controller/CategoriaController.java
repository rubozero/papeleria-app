package com.papeleria.my_app.controller;

import com.papeleria.my_app.entity.CategoriaProducto;
import com.papeleria.my_app.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<CategoriaProducto> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);
        return "categoria";
    }

    @PostMapping("/categoria")
    public String agregarCategoria(@RequestParam String nombreCategoria) {
        categoriaService.crearCategoria(nombreCategoria);
        return "redirect:/categorias";
    }

    @PostMapping("/categoria/actualizar")
    public String actualizarCategoria(@RequestParam Integer id, @RequestParam String nombreCategoria) {
        categoriaService.actualizarCategoria(id, nombreCategoria);
        return "redirect:/categorias";
    }

    @PostMapping("/categoria/eliminar")
    public String eliminarCategoria(@RequestParam Integer id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}