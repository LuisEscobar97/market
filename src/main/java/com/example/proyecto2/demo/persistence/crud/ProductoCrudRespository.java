package com.example.proyecto2.demo.persistence.crud;

import com.example.proyecto2.demo.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRespository extends CrudRepository<Producto,Integer> {

    List<Producto> findByIdCategoria(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);


}
