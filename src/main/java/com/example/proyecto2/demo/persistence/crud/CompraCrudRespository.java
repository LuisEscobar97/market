package com.example.proyecto2.demo.persistence.crud;

import com.example.proyecto2.demo.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRespository  extends CrudRepository<Compra,Integer> {


    Optional<List<Compra>> findByIdCliente(String idCliente);
}
