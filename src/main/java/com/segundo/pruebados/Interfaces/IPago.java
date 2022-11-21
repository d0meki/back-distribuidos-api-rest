package com.segundo.pruebados.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.segundo.pruebados.model.Pago;

@Repository
public interface IPago extends CrudRepository<Pago,Integer>{
    
}
