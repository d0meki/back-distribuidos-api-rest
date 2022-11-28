package com.segundo.pruebados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDeudaService;
import com.segundo.pruebados.Interfaces.IDeuda;
import com.segundo.pruebados.model.Deuda;

@Service
public class DeudaService implements IDeudaService {

    @Autowired
    private IDeuda data;

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
    
}
