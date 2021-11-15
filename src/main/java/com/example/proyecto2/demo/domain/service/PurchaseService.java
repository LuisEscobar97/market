package com.example.proyecto2.demo.domain.service;

import com.example.proyecto2.demo.domain.Purchase;
import com.example.proyecto2.demo.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase>getAll() {
        return purchaseRepository.getAll();
    }
    public Optional<List<Purchase>>getByClientId(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
