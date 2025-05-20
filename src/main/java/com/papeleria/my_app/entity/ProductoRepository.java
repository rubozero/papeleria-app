package com.papeleria.my_app.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, stock, id_categoria) VALUES (:nombre, :precioCompra, :precioVenta, :stock, :idCategoria)", nativeQuery = true)
    void insertProducto(String nombre, java.math.BigDecimal precioCompra, java.math.BigDecimal precioVenta, Integer stock, Integer idCategoria);

    // READ
    @Query(value = "SELECT * FROM PRODUCTO", nativeQuery = true)
    List<Producto> findAllProductosNative();

    @Query(value = "SELECT * FROM PRODUCTO WHERE id_producto = :id", nativeQuery = true)
    Producto findProductoByIdNative(Long id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUCTO SET nombre = :nombre, precio_compra = :precioCompra, precio_venta = :precioVenta, stock = :stock, id_categoria = :idCategoria WHERE id_producto = :id", nativeQuery = true)
    void updateProducto(Long id, String nombre, java.math.BigDecimal precioCompra, java.math.BigDecimal precioVenta, Integer stock, Integer idCategoria);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PRODUCTO WHERE id_producto = :id", nativeQuery = true)
    void deleteProductoByIdNative(Long id);
}
