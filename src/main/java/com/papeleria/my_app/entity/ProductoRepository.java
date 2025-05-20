package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, stock, nombre_proveedor, id_categoria) VALUES (:nombre, :precioCompra, :precioVenta, :stock, :nombreProveedor, :idCategoria)", nativeQuery = true)
    void insertProducto(String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Integer stock, String nombreProveedor, Integer idCategoria);

    // READ ALL
    @Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
    List<Producto> findAllProductosNative();

    // READ BY ID
    @Query(value = "SELECT * FROM PRODUCTO WHERE id_producto = :id", nativeQuery = true)
    Producto findProductoByIdNative(Long id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUCTO SET nombre = :nombre, precio_compra = :precioCompra, precio_venta = :precioVenta, stock = :stock, nombre_proveedor = :nombreProveedor, id_categoria = :idCategoria WHERE id_producto = :id", nativeQuery = true)
    void updateProducto(Long id, String nombre, BigDecimal precioCompra, BigDecimal precioVenta, Integer stock, String nombreProveedor, Integer idCategoria);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRODUCTO WHERE id_producto = :id", nativeQuery = true)
    void deleteProductoByIdNative(Long id);
}
