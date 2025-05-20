package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.CategoriaProducto;
import com.papeleria.my_app.entity.CategoriaProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaProductoRepository categoriaProductoRepository;

    public CategoriaService(CategoriaProductoRepository categoriaProductoRepository) {
        this.categoriaProductoRepository = categoriaProductoRepository;
    }

    // Obtener todas las categorías
    public List<CategoriaProducto> obtenerTodasLasCategorias() {
        return categoriaProductoRepository.findAllCategoriasNative();
    }

    // Crear una nueva categoría
    public void crearCategoria(String nombreCategoria) {
        categoriaProductoRepository.insertCategoria(nombreCategoria);
    }

    // Actualizar una categoría existente
    public void actualizarCategoria(Integer id, String nombreCategoria) {
        categoriaProductoRepository.updateCategoria(id, nombreCategoria);
    }

    // Eliminar una categoría
    public void eliminarCategoria(Integer id) {
        categoriaProductoRepository.deleteCategoriaByIdNative(id);
    }
}
