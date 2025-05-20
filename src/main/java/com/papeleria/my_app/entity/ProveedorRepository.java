package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PROVEEDOR (nombre, telefono, email) VALUES (:nombre, :telefono, :email)", nativeQuery = true)
    void insertProveedor(String nombre, String telefono, String email);

    // READ ALL
    @Query(value = "SELECT * FROM PROVEEDOR", nativeQuery = true)
    List<Proveedor> findAllProveedoresNative();

    // READ BY ID
    @Query(value = "SELECT * FROM PROVEEDOR WHERE id_proveedor = :id", nativeQuery = true)
    Proveedor findProveedorByIdNative(Long id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE PROVEEDOR SET nombre = :nombre, telefono = :telefono, email = :email WHERE id_proveedor = :id", nativeQuery = true)
    void updateProveedor(Long id, String nombre, String telefono, String email);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PROVEEDOR WHERE id_proveedor = :id", nativeQuery = true)
    void deleteProveedorByIdNative(Long id);
}