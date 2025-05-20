package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.Empleado;
import com.papeleria.my_app.entity.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // CREATE
    public void crearEmpleado(String nombre, String turno) {
        empleadoRepository.insertEmpleado(nombre, turno);
    }

    // READ ALL
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAllEmpleadosNative();
    }

    // READ BY ID
    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findEmpleadoByIdNative(id);
    }

    // UPDATE
    public void actualizarEmpleado(Long id, String nombre, String turno) {
        empleadoRepository.updateEmpleado(id, nombre, turno);
    }

    // DELETE
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteEmpleadoByIdNative(id);
    }
}