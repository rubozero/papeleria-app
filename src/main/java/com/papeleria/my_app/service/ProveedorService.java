package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.Proveedor;
import com.papeleria.my_app.entity.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    // CREATE
    public void crearProveedor(String nombre, String telefono, String email) {
        proveedorRepository.insertProveedor(nombre, telefono, email);
    }

    // READ ALL
    public List<Proveedor> obtenerTodosLosProveedores() {
        return proveedorRepository.findAllProveedoresNative();
    }

    // READ BY ID
    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findProveedorByIdNative(id);
    }

    // UPDATE
    public void actualizarProveedor(Integer id, String nombre, String telefono, String email) {
        proveedorRepository.updateProveedor(id, nombre, telefono, email);
    }

    // DELETE
    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteProveedorByIdNative(id);
    }
}