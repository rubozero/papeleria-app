package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Empleado (nombre, turno) VALUES (:nombre, :turno)", nativeQuery = true)
    void insertEmpleado(String nombre, String turno);

    // READ ALL
    @Query(value = "SELECT * FROM Empleado", nativeQuery = true)
    List<Empleado> findAllEmpleadosNative();

    // READ BY ID
    @Query(value = "SELECT * FROM Empleado WHERE id_empleado = :id", nativeQuery = true)
    Empleado findEmpleadoByIdNative(Integer id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Empleado SET nombre = :nombre, turno = :turno WHERE id_empleado = :id", nativeQuery = true)
    void updateEmpleado(Integer id, String nombre, String turno);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Empleado WHERE id_empleado = :id", nativeQuery = true)
    void deleteEmpleadoByIdNative(Integer id);
}