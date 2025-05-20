package com.papeleria.my_app.controller;

import com.papeleria.my_app.service.ProductoService;
import com.papeleria.my_app.service.CategoriaService;
import com.papeleria.my_app.entity.Producto;
import com.papeleria.my_app.entity.CategoriaProducto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @ModelAttribute("categorias")
    public List<CategoriaProducto> categorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }

    // Página de productos
    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "producto";
    }

    @PostMapping("/producto")
    public String crearProducto(@RequestParam String nombre,
                                @RequestParam BigDecimal precioCompra,
                                @RequestParam BigDecimal precioVenta,
                                @RequestParam Integer stock,
                                @RequestParam Integer idCategoria) {
        productoService.crearProducto(nombre, precioCompra, precioVenta, stock, idCategoria);
        return "redirect:/productos";
    }

    @GetMapping("/producto/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("producto", producto);
        return "producto-detalle";
    }

    @PostMapping("/producto/actualizar")
    public String actualizarProducto(@RequestParam Long id,
                                     @RequestParam String nombre,
                                     @RequestParam BigDecimal precioCompra,
                                     @RequestParam BigDecimal precioVenta,
                                     @RequestParam Integer stock,
                                     @RequestParam Integer idCategoria) {
        productoService.actualizarProducto(id, nombre, precioCompra, precioVenta, stock, idCategoria);
        return "redirect:/productos";
    }

    @PostMapping("/producto/eliminar")
    public String eliminarProducto(@RequestParam Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}