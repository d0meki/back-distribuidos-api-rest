package com.segundo.pruebados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.segundo.pruebados.InterfaceService.IPagoService;
import com.segundo.pruebados.Interfaces.IDetallePagoDeuda;
import com.segundo.pruebados.Interfaces.IPago;
import com.segundo.pruebados.model.DetallePagoDeuda;
import com.segundo.pruebados.model.Pago;

@Service
public class PagoService implements IPagoService{

    @Autowired
    private IPago dataPago;
    @Autowired
    private IDetallePagoDeuda data;

    @Override
    public ResponseEntity<Pago> create(Pago pago, int id) {
        try {
            Pago p = dataPago.save(pago);
            DetallePagoDeuda dpd = new DetallePagoDeuda();
            dpd.setDeuda_id(id);
            dpd.setPago_id(p.getId());
            data.save(dpd);
            return new ResponseEntity<Pago>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
