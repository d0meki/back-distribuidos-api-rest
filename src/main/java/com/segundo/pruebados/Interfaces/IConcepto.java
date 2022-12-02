package com.segundo.pruebados.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.segundo.pruebados.model.Concepto;

@Repository
public interface IConcepto extends CrudRepository<Concepto,Integer>{
    
}
