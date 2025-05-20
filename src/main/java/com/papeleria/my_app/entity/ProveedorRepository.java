package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    // CREATE
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Proveedor (nombre, telefono, email) VALUES (:nombre, :telefono, :email)", nativeQuery = true)
    void insertProveedor(String nombre, String telefono, String email);

    // READ ALL
    @Query(value = "SELECT * FROM Proveedor", nativeQuery = true)
    List<Proveedor> findAllProveedoresNative();

    // READ BY ID
    @Query(value = "SELECT * FROM Proveedor WHERE id_proveedor = :id", nativeQuery = true)
    Proveedor findProveedorByIdNative(Integer id);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE Proveedor SET nombre = :nombre, telefono = :telefono, email = :email WHERE id_proveedor = :id", nativeQuery = true)
    void updateProveedor(Integer id, String nombre, String telefono, String email);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Proveedor WHERE id_proveedor = :id", nativeQuery = true)
    void deleteProveedorByIdNative(Integer id);
}