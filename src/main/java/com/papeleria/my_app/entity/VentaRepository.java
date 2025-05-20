package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO VENTA (fecha, id_empleado, total) VALUES (:fecha, :idEmpleado, :total)", nativeQuery = true)
    void insertVenta(LocalDateTime fecha, Long idEmpleado, BigDecimal total);

    // READ ALL
    @Query(value = "SELECT * FROM VENTA", nativeQuery = true)
    List<Venta> findAllVentasNative();

    // READ BY ID
    @Query(value = "SELECT * FROM VENTA WHERE id_venta = :id", nativeQuery = true)
    Venta findVentaByIdNative(Long id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE VENTA SET fecha = :fecha, id_empleado = :idEmpleado, total = :total WHERE id_venta = :id", nativeQuery = true)
    void updateVenta(Long id, LocalDateTime fecha, Long idEmpleado, BigDecimal total);

    // UPDATE SIN FECHA
    @Modifying
    @Transactional
    @Query(value = "UPDATE VENTA SET id_empleado = :idEmpleado, total = :total WHERE id_venta = :id", nativeQuery = true)
    void updateVentaSinFecha(Long id, Long idEmpleado, BigDecimal total);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM VENTA WHERE id_venta = :id", nativeQuery = true)
    void deleteVentaByIdNative(Long id);
}