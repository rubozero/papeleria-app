package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.Venta;
import com.papeleria.my_app.entity.VentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    // CREATE
    public void crearVenta(LocalDateTime fecha, Integer idEmpleado, BigDecimal total) {
        ventaRepository.insertVenta(fecha, idEmpleado, total);
    }

    // READ ALL
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAllVentasNative();
    }

    // READ BY ID
    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findVentaByIdNative(id);
    }

    // READ BY EMPLEADO
    public List<Venta> obtenerVentasPorEmpleado(Integer idEmpleado) {
        return ventaRepository.findVentasByEmpleadoNative(idEmpleado);
    }

    // UPDATE
    public void actualizarVenta(Integer id, LocalDateTime fecha, Integer idEmpleado, BigDecimal total) {
        ventaRepository.updateVenta(id, fecha, idEmpleado, total);
    }

    public void actualizarVentaSinFecha(Integer id, Integer idEmpleado, BigDecimal total) {
        ventaRepository.updateVentaSinFecha(id, idEmpleado, total);
    }

    // DELETE
    public void eliminarVenta(Integer id) {
        ventaRepository.deleteVentaByIdNative(id);
    }
}