package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO DetalleVenta (id_venta, id_producto, cantidad, subtotal) VALUES (:idVenta, :idProducto, :cantidad, :subtotal)", nativeQuery = true)
    void insertDetalleVenta(Integer idVenta, Integer idProducto, Integer cantidad, BigDecimal subtotal);

    // READ ALL
    @Query(value = "SELECT * FROM DetalleVenta", nativeQuery = true)
    List<DetalleVenta> findAllDetallesNative();

    // READ BY ID
    @Query(value = "SELECT * FROM DetalleVenta WHERE id_detalle = :id", nativeQuery = true)
    DetalleVenta findDetalleByIdNative(Integer id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE DetalleVenta SET id_venta = :idVenta, id_producto = :idProducto, cantidad = :cantidad, subtotal = :subtotal WHERE id_detalle = :id", nativeQuery = true)
    void updateDetalleVenta(Integer id, Integer idVenta, Integer idProducto, Integer cantidad, BigDecimal subtotal);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM DetalleVenta WHERE id_detalle = :id", nativeQuery = true)
    void deleteDetalleVentaByIdNative(Integer id);
}