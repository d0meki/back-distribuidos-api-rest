package com.segundo.pruebados.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.segundo.pruebados.model.DetalleDeuda;
@Repository
public interface IDetalleDeuda extends CrudRepository<DetalleDeuda,Integer>{
    
}
