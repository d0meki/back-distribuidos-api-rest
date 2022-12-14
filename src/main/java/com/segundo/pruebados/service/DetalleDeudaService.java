package com.segundo.pruebados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDetalleDeudaService;
import com.segundo.pruebados.Interfaces.IDetalleDeuda;
import com.segundo.pruebados.model.Detalle;
import com.segundo.pruebados.model.DetalleDeuda;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
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

    // @Override
    // public ResponseEntity<List<Detalle>> getDetallesJoin(int deuda_id) {
    //     try {
    //         // List<Detalle> detalleDeuda = em.createNativeQuery("SELECT detalle_deudas.id,detalle_deudas.deuda_id, detalle_deudas.monto, conceptos.descripcion FROM detalle_deudas,conceptos WHERE detalle_deudas.concepto_id=conceptos.id AND detalle_deudas.deuda_id=:id",Detalle.class)
    //         // .setParameter("id", deuda_id)
    //         // .getResultList();
    //         List<Detalle> detalleDeuda = em.createNativeQuery("SELECT detalle_deudas.id,detalle_deudas.deuda_id,detalle_deudas.monto,conceptos.descripcion FROM detalle_deudas,conceptos WHERE detalle_deudas.concepto_id=conceptos.id AND detalle_deudas.deuda_id=12",Detalle.class)
    //         .getResultList();

    //         return new ResponseEntity<List<Detalle>>(detalleDeuda, HttpStatus.ACCEPTED);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    @Override
    public ResponseEntity<List<Detalle>> getDetallesJoin(int deuda_id) {
        try {
            // List<Detalle> detalleDeuda = em.createNativeQuery("SELECT detalle_deudas.id,detalle_deudas.deuda_id, detalle_deudas.monto, conceptos.descripcion FROM detalle_deudas,conceptos WHERE detalle_deudas.concepto_id=conceptos.id AND detalle_deudas.deuda_id=:id",Detalle.class)
            // .setParameter("id", deuda_id)
            // .getResultList();
            List<Object[]> detalleDeuda = em.createNativeQuery("SELECT detalle_deudas.id,detalle_deudas.deuda_id,detalle_deudas.monto,conceptos.descripcion FROM detalle_deudas,conceptos WHERE detalle_deudas.concepto_id=conceptos.id AND detalle_deudas.deuda_id=:id")
            .setParameter("id", deuda_id)
            .getResultList();
            List<Detalle> lista = new ArrayList<>();   
                for (Object[] object : detalleDeuda) {
                    Detalle d = new Detalle((int)object[0],(int)object[1],(float)object[2],object[3].toString());
                    lista.add(d);
                }
            return new ResponseEntity<List<Detalle>>(lista, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
