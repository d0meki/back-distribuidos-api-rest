package com.segundo.pruebados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDetalleDeudaService;
import com.segundo.pruebados.Interfaces.IDetalleDeuda;
import com.segundo.pruebados.Interfaces.IDeuda;
import com.segundo.pruebados.model.DetalleDeuda;
import com.segundo.pruebados.model.Deuda;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleDeudaService implements IDetalleDeudaService{

    @Autowired
    private IDeuda dataDeuda;
    @Autowired
    private IDetalleDeuda dataDetalleDeuda;
    @PersistenceContext
    private EntityManager em;

    @Override
    public ResponseEntity<DetalleDeuda> create(DetalleDeuda detalleDeuda) {
        try {

            // Optional<Deuda> deuda = dataDeuda.findById(detalleDeuda.getDeuda_id());
            // Deuda _deuda = deuda.get();
            // float total = _deuda.getTotal() + detalleDeuda.getMonto();
            // _deuda.setTotal(total);
            // dataDeuda.save(_deuda);

            return new ResponseEntity<DetalleDeuda>(dataDetalleDeuda.save(detalleDeuda), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @Override
    public ResponseEntity<List<DetalleDeuda>> getDetalles(int deuda_id) {
        try {
            List<DetalleDeuda> detalleDeuda = em.createNativeQuery("SELECT*FROM detalle_deudas WHERE detalle_deudas.deuda_id = :id",DetalleDeuda.class)
            .setParameter("id", deuda_id)
            .getResultList();
            return new ResponseEntity<List<DetalleDeuda>>(detalleDeuda, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
