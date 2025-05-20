package com.papeleria.my_app.service;

import com.papeleria.my_app.entity.DetalleVenta;
import com.papeleria.my_app.entity.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    // CREATE
    public void crearDetalleVenta(Long idVenta, Long idProducto, Integer cantidad, BigDecimal subtotal) {
        detalleVentaRepository.insertDetalleVenta(idVenta, idProducto, cantidad, subtotal);
    }

    // READ ALL
    public List<DetalleVenta> obtenerTodosLosDetalles() {
        return detalleVentaRepository.findAllDetallesNative();
    }

    // READ BY ID
    public DetalleVenta obtenerDetallePorId(Long id) {
        return detalleVentaRepository.findDetalleByIdNative(id);
    }

    // UPDATE
    public void actualizarDetalleVenta(Long id, Long idVenta, Long idProducto, Integer cantidad, BigDecimal subtotal) {
        detalleVentaRepository.updateDetalleVenta(id, idVenta, idProducto, cantidad, subtotal);
    }

    // DELETE
    public void eliminarDetalleVenta(Long id) {
        detalleVentaRepository.deleteDetalleVentaByIdNative(id);
    }
}