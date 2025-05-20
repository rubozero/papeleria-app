package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EMPLEADO (nombre, turno) VALUES (:nombre, :turno)", nativeQuery = true)
    void insertEmpleado(String nombre, String turno);

    // READ ALL
    @Query(value = "SELECT * FROM EMPLEADO", nativeQuery = true)
    List<Empleado> findAllEmpleadosNative();

    // READ BY ID
    @Query(value = "SELECT * FROM EMPLEADO WHERE id_empleado = :id", nativeQuery = true)
    Empleado findEmpleadoByIdNative(Long id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE EMPLEADO SET nombre = :nombre, turno = :turno WHERE id_empleado = :id", nativeQuery = true)
    void updateEmpleado(Long id, String nombre, String turno);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EMPLEADO WHERE id_empleado = :id", nativeQuery = true)
    void deleteEmpleadoByIdNative(Long id);
}