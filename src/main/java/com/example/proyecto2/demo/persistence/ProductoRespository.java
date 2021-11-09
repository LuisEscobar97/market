package com.example.proyecto2.demo.persistence;

import com.example.proyecto2.demo.persistence.crud.ProductoCrudRespository;
import com.example.proyecto2.demo.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRespository {
    private ProductoCrudRespository productoCrudRespository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRespository.findAll();
    }

    public List<Producto> getByCategoria(int idcategoria){
        return productoCrudRespository.findByIdCategoria(idcategoria);
    }

    public Optional<List<Producto>> getByStock(int catidadStock,boolean estado){
        return productoCrudRespository.findByCantidadStockLessThanAndEstado(catidadStock,estado);
    }
    public Optional<Producto> getProducto(int idProducto){
            return  productoCrudRespository.findById(idProducto);
    }

    public Producto saveProducto(Producto producto){
        return productoCrudRespository.save(producto);
    }

    public void deleteProducto(int idProducto){
        productoCrudRespository.deleteById(idProducto);
    }
}
