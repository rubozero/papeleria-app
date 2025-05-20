package com.papeleria.my_app.entity;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> { 
    @Query(value = "SELECT * FROM CategoriaProducto", nativeQuery = true)
    List<CategoriaProducto> findAllCategoriasNative();

    @Query(value = "SELECT * FROM CategoriaProducto WHERE id_categoria = :id", nativeQuery = true)
    CategoriaProducto findCategoriaByIdNative(Integer id);

    @Query(value = "SELECT * FROM CategoriaProducto WHERE nombre_categoria = :nombre", nativeQuery = true)
    CategoriaProducto findCategoriaByNombreNative(String nombre);

    // INSERT
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CategoriaProducto (nombre_categoria) VALUES (:nombreCategoria)", nativeQuery = true)
    void insertCategoria(String nombreCategoria);

    // UPDATE
    @Modifying
    @Transactional
    @Query(value = "UPDATE CategoriaProducto SET nombre_categoria = :nombreCategoria WHERE id_categoria = :id", nativeQuery = true)
    void updateCategoria(Integer id, String nombreCategoria);

    // DELETE
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CategoriaProducto WHERE id_categoria = :id", nativeQuery = true)
    void deleteCategoriaByIdNative(Integer id);
}
