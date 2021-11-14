package com.example.proyecto2.demo.persistence;

import com.example.proyecto2.demo.domain.Product;
import com.example.proyecto2.demo.domain.repository.ProductRepository;
import com.example.proyecto2.demo.persistence.crud.ProductoCrudRespository;
import com.example.proyecto2.demo.persistence.entity.Producto;
import com.example.proyecto2.demo.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRespository implements ProductRepository {

    @Autowired
    private ProductoCrudRespository productoCrudRespository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){

    List<Producto> productos=(List<Producto>) productoCrudRespository.findAll();
        return productMapper.toOroducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto>productos=productoCrudRespository.findByIdCategoria(categoryId);
        return Optional.of(productMapper.toOroducts(productos));
    }

    @Override
    public Optional<List<Product>> getScareseProducts(int quantity) {
        Optional<List<Producto>>products=productoCrudRespository.findByCantidadStockLessThanAndEstado(quantity,true);
        return products.map(productos -> productMapper.toOroducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRespository.findById(productId).map(producto -> productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto=productMapper.toProdcto(product);
        producto=productoCrudRespository.save(producto);
        return productMapper.toProduct(producto);
    }

    @Override
    public void delete(int productId) {
        productoCrudRespository.deleteById(productId);
    }

}
