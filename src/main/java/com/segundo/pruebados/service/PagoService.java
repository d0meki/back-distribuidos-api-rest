package com.segundo.pruebados.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IPagoService;
import com.segundo.pruebados.Interfaces.IPago;
import com.segundo.pruebados.model.Pago;

@Service
public class PagoService implements IPagoService{

    @Autowired
    private IPago dataPago;
    @PersistenceContext
    private EntityManager em;

    @Override
    public ResponseEntity<Pago> create(Pago pago) {
        try {
            Pago p = dataPago.save(pago);
            return new ResponseEntity<Pago>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Pago> getPago(int deuda_id) {
        try {
            Pago detalleDeuda = (Pago) em.createNativeQuery("SELECT*FROM pagos WHERE pagos.deuda_id = :id",Pago.class)
            .setParameter("id", deuda_id)
            .getSingleResult();
            return new ResponseEntity<Pago>(detalleDeuda, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
