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
    public void crearVenta(LocalDateTime fecha, Long idEmpleado, BigDecimal total) {
        ventaRepository.insertVenta(fecha, idEmpleado, total);
    }

    // READ ALL
    public List<Venta> obtenerTodasLasVentas() {
        return ventaRepository.findAllVentasNative();
    }

    // READ BY ID
    public Venta obtenerVentaPorId(Long id) {
        return ventaRepository.findVentaByIdNative(id);
    }

    // UPDATE
    public void actualizarVenta(Long id, LocalDateTime fecha, Long idEmpleado, BigDecimal total) {
        ventaRepository.updateVenta(id, fecha, idEmpleado, total);
    }

    public void actualizarVentaSinFecha(Long id, Long idEmpleado, BigDecimal total) {
        ventaRepository.updateVentaSinFecha(id, idEmpleado, total);
    }

    // DELETE
    public void eliminarVenta(Long id) {
        ventaRepository.deleteVentaByIdNative(id);
    }
}