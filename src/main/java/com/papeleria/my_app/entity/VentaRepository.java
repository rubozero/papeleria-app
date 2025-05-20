package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Venta (fecha, id_empleado, total) VALUES (:fecha, :idEmpleado, :total)", nativeQuery = true)
    void insertVenta(LocalDateTime fecha, Integer idEmpleado, BigDecimal total);

    // READ ALL
    @Query(value = "SELECT * FROM Venta", nativeQuery = true)
    List<Venta> findAllVentasNative();

    // READ BY ID
    @Query(value = "SELECT * FROM Venta WHERE id_venta = :id", nativeQuery = true)
    Venta findVentaByIdNative(Integer id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Venta SET fecha = :fecha, id_empleado = :idEmpleado, total = :total WHERE id_venta = :id", nativeQuery = true)
    void updateVenta(Integer id, LocalDateTime fecha, Integer idEmpleado, BigDecimal total);

    // UPDATE SIN FECHA
    @Modifying
    @Transactional
    @Query(value = "UPDATE Venta SET id_empleado = :idEmpleado, total = :total WHERE id_venta = :id", nativeQuery = true)
    void updateVentaSinFecha(Integer id, Integer idEmpleado, BigDecimal total);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Venta WHERE id_venta = :id", nativeQuery = true)
    void deleteVentaByIdNative(Integer id);
}