package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.Producto;
import com.papeleria.my_app.entity.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // CREATE
    public void crearProducto(String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Integer stock, String nombreProveedor, Integer idCategoria) {
        productoRepository.insertProducto(nombre, precioCompra, precioVenta, stock, nombreProveedor, idCategoria);
    }

    // READ ALL
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAllProductosNative();
    }

    // READ BY ID
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findProductoByIdNative(id);
    }

    // UPDATE
    public void actualizarProducto(Long id, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Integer stock, String nombreProveedor, Integer idCategoria) {
        productoRepository.updateProducto(id, nombre, precioCompra, precioVenta, stock, nombreProveedor, idCategoria);
    }

    // DELETE
    public void eliminarProducto(Long id) {
        productoRepository.deleteProductoByIdNative(id);
    }
}
