package com.segundo.pruebados.InterfaceService;
import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Deuda;

public interface IDeudaService {
    public ResponseEntity<Deuda> create(Deuda deuda);
    public ResponseEntity<List<Deuda>> buscar(int id);
    public Optional<Deuda> editar(Deuda deuda);
    public List<Deuda> listar();
}
