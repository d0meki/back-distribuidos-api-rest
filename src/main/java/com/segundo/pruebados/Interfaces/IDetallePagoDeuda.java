package com.segundo.pruebados.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.segundo.pruebados.model.DetallePagoDeuda;
@Repository
public interface IDetallePagoDeuda extends CrudRepository<DetallePagoDeuda,Integer>{
    
}
