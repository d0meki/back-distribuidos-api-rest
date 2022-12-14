package com.segundo.pruebados.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.Interfaces.IDeuda;
import com.segundo.pruebados.model.Deuda;
import com.segundo.pruebados.model.DeudaCi;

@Service
public class DeudaService implements IDeudaService {

    @Autowired
    private IDeuda data;
    @PersistenceContext
    private EntityManager em;

    @Override
    public ResponseEntity<Deuda> create(Deuda deuda) {
        try {
            return new ResponseEntity<Deuda>(data.save(deuda), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Optional<Deuda> editar(Deuda deuda) {
        Optional<Deuda> deudaId = data.findById(deuda.getId());
        Deuda _deuda = deudaId.get();
        _deuda.setPagado(deuda.isPagado());
        data.save(_deuda);
        return data.findById(deuda.getId());
    }

    @Override
    public List<Deuda> listar() {
        return (List<Deuda>) data.findAll();
    }

    @Override
    public ResponseEntity<List<Deuda>> buscar(int id) {
        try {
            List<Deuda> d = em.createNativeQuery("SELECT*FROM deudas WHERE deudas.persona_id = :id AND deudas.pagado = FALSE",Deuda.class)
            .setParameter("id", id)
            .getResultList();
            return new ResponseEntity<List<Deuda>>(d, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Deuda>> historial(int id) {
        try {
            List<Deuda> d = em.createNativeQuery("SELECT*FROM deudas WHERE deudas.persona_id = :id AND deudas.pagado = TRUE",Deuda.class)
            .setParameter("id", id)
            .getResultList();
            return new ResponseEntity<List<Deuda>>(d, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<DeudaCi>> buscarCi(String ci) {
        try {
            List<Object[]> d = em.createNativeQuery("SELECT deudas.id,deudas.persona_id,deudas.fecha_creacion,deudas.fecha_vencimiento,deudas.pagado,persona.name,deudas.titulo,deudas.total FROM deudas, persona WHERE deudas.persona_id=persona.id AND deudas.pagado=0 AND persona.ci=:id")
            .setParameter("id", ci)
            .getResultList();
            
            List<DeudaCi> deudasPorCI = new ArrayList<>();
            for (Object[] object : d) {
                DeudaCi deuda = new DeudaCi((int)object[0],(int)object[1],(Date)object[2],(Date)object[3],(boolean)object[4],object[5].toString(),object[6].toString(),(float)object[7]);
                deudasPorCI.add(deuda);
            }
            return new ResponseEntity<List<DeudaCi>>(deudasPorCI, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<List<DeudaCi>> historialCi(String ci) {
        try {
            List<Object[]> d = em.createNativeQuery("SELECT deudas.id,deudas.persona_id,deudas.fecha_creacion,deudas.fecha_vencimiento,deudas.pagado,persona.name,deudas.titulo,deudas.total FROM deudas, persona WHERE deudas.persona_id=persona.id AND deudas.pagado=1 AND persona.ci=:id")
            .setParameter("id", ci)
            .getResultList();
            
            List<DeudaCi> deudasPorCI = new ArrayList<>();
            for (Object[] object : d) {
                DeudaCi deuda = new DeudaCi((int)object[0],(int)object[1],(Date)object[2],(Date)object[3],(boolean)object[4],object[5].toString(),object[6].toString(),(float)object[7]);
                deudasPorCI.add(deuda);
            }
            return new ResponseEntity<List<DeudaCi>>(deudasPorCI, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
