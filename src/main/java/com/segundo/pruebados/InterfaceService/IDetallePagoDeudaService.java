package com.segundo.pruebados.InterfaceService;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.segundo.pruebados.model.DetallePagoDeuda;
import com.segundo.pruebados.model.PagoDeuda;

public interface IDetallePagoDeudaService {
    public ResponseEntity<DetallePagoDeuda> create(DetallePagoDeuda detallePagoDeuda);
    public List<PagoDeuda> getDetallePAgoDeda();
}
