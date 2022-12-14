package com.segundo.pruebados.InterfaceService;
import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.Deuda;
import com.segundo.pruebados.model.DeudaCi;

public interface IDeudaService {
    public ResponseEntity<Deuda> create(Deuda deuda);
    public ResponseEntity<List<Deuda>> buscar(int id);
    public ResponseEntity<List<DeudaCi>> buscarCi(String ci);
    public ResponseEntity<List<DeudaCi>> historialCi(String ci);
    public ResponseEntity<List<Deuda>> historial(int id);
    public Optional<Deuda> editar(Deuda deuda);
    public List<Deuda> listar();
}
