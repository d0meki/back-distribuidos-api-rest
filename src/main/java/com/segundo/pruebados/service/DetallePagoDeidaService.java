package com.segundo.pruebados.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IDetallePagoDeudaService;
import com.segundo.pruebados.Interfaces.IDetallePagoDeuda;
import com.segundo.pruebados.model.DetallePagoDeuda;
import com.segundo.pruebados.model.PagoDeuda;

@Service
public class DetallePagoDeidaService implements IDetallePagoDeudaService {

    @Autowired
    private IDetallePagoDeuda dataDetallePagoDeuda;
    @Autowired
    private EntityManager em;

    @Override
    public ResponseEntity<DetallePagoDeuda> create(DetallePagoDeuda detallePagoDeuda) {
        try {
            return new ResponseEntity<DetallePagoDeuda>(dataDetallePagoDeuda.save(detallePagoDeuda), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public List<PagoDeuda> getDetallePAgoDeda() {
       Query nativeQuery = em.createNativeQuery("SELECT deudas.titulo,deudas.total,pagos.id, pagos.monto FROM `detalle_pago_deudas` JOIN deudas ON deudas.id = detalle_pago_deudas.deuda_id JOIN pagos ON pagos.id = detalle_pago_deudas.pago_id");
       final List<Object[]> results = nativeQuery.getResultList();
       return results
            .stream()
            .map(result -> new PagoDeuda( (String)result[0],(float)result[1],(int)result[2],(float)result[3]))
            .collect(Collectors.toList());
        //return results;
    }
    
}
