package com.segundo.pruebados.service;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IPagoService;
import com.segundo.pruebados.Interfaces.IPago;
import com.segundo.pruebados.model.Pago;
import com.segundo.pruebados.model.PagoDeuda;

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

    @Override
    public ResponseEntity<PagoDeuda> getPagoName(int deuda_id) {
        try {
            Query q = em.createNativeQuery("SELECT pagos.id,pagos.deuda_id,pagos.fecha_pago,pagos.monto,persona.name FROM pagos,persona WHERE pagos.persona_id=persona.id AND pagos.deuda_id = :id")
            .setParameter("id", deuda_id);
            Object[] pago = (Object[]) q.getSingleResult();

            PagoDeuda pagoDeuda = new PagoDeuda((int)pago[0], (int)pago[1],(java.sql.Date)pago[2], (float)pago[3],pago[4].toString());
            return new ResponseEntity<PagoDeuda>(pagoDeuda, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
