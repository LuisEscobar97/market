package com.example.proyecto2.demo.persistence;

import com.example.proyecto2.demo.domain.Purchase;
import com.example.proyecto2.demo.domain.repository.PurchaseRepository;
import com.example.proyecto2.demo.persistence.crud.CompraCrudRespository;
import com.example.proyecto2.demo.persistence.entity.Compra;
import com.example.proyecto2.demo.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ComprasRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRespository compraCrudRespository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRespository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRespository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra= mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRespository.save(compra));
    }
}
