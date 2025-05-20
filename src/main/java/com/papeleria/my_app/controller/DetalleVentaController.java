package com.papeleria.my_app.controller;

import com.papeleria.my_app.entity.DetalleVenta;
import com.papeleria.my_app.entity.Producto;
import com.papeleria.my_app.entity.Venta;
import com.papeleria.my_app.service.DetalleVentaService;
import com.papeleria.my_app.service.ProductoService;
import com.papeleria.my_app.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;
    private final VentaService ventaService;
    private final ProductoService productoService;

    public DetalleVentaController(DetalleVentaService detalleVentaService, VentaService ventaService, ProductoService productoService) {
        this.detalleVentaService = detalleVentaService;
        this.ventaService = ventaService;
        this.productoService = productoService;
    }

    // Mostrar listado de detalles de venta
    @GetMapping("/detalle-venta")
    public String listarDetalles(Model model) {
        List<DetalleVenta> detalles = detalleVentaService.obtenerTodosLosDetalles();
        List<Venta> ventas = ventaService.obtenerTodasLasVentas();
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("detalles", detalles);
        model.addAttribute("ventas", ventas);
        model.addAttribute("productos", productos);
        return "detalle-venta";
    }

    // Agregar detalle de venta
    @PostMapping("/detalle-venta")
    public String agregarDetalle(@RequestParam Integer idVenta,
                                 @RequestParam Integer idProducto,
                                 @RequestParam Integer cantidad,
                                 @RequestParam BigDecimal subtotal) {
        detalleVentaService.crearDetalleVenta(idVenta, idProducto, cantidad, subtotal);
        return "redirect:/detalle-venta";
    }

    // Actualizar detalle de venta
    @PostMapping("/detalle-venta/actualizar")
    public String actualizarDetalle(@RequestParam Integer id,
                                    @RequestParam Integer idVenta,
                                    @RequestParam Integer idProducto,
                                    @RequestParam Integer cantidad,
                                    @RequestParam BigDecimal subtotal) {
        detalleVentaService.actualizarDetalleVenta(id, idVenta, idProducto, cantidad, subtotal);
        return "redirect:/detalle-venta";
    }

    // Eliminar detalle de venta
    @PostMapping("/detalle-venta/eliminar")
    public String eliminarDetalle(@RequestParam Integer id) {
        detalleVentaService.eliminarDetalleVenta(id);
        return "redirect:/detalle-venta";
    }
}