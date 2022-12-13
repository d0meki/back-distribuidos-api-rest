package com.segundo.pruebados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDetalleDeudaService;
import com.segundo.pruebados.Interfaces.IDetalleDeuda;
import com.segundo.pruebados.model.Detalle;
import com.segundo.pruebados.model.DetalleDeuda;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Service
public class DetalleDeudaService implements IDetalleDeudaService{

    @Autowired
    private IDetalleDeuda dataDetalleDeuda;
    @PersistenceContext
    private EntityManager em;

    @Override
    public ResponseEntity<DetalleDeuda> create(DetalleDeuda detalleDeuda) {
        try {

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

    @Override
    public ResponseEntity<List<Detalle>> getDetallesJoin(int deuda_id) {
        try {
            List<Detalle> detalleDeuda = em.createNativeQuery("SELECT detalle_deudas.id,detalle_deudas.deuda_id,detalle_deudas.monto,conceptos.descripcion FROM detalle_deudas INNER JOIN conceptos ON detalle_deudas.concepto_id=conceptos.id WHERE detalle_deudas.deuda_id = :id",Detalle.class)
            .setParameter("id", deuda_id)
            .getResultList();
            return new ResponseEntity<List<Detalle>>(detalleDeuda, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
