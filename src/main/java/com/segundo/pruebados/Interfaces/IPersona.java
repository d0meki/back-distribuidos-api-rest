package com.segundo.pruebados.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.segundo.pruebados.model.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona,Integer>{ }
