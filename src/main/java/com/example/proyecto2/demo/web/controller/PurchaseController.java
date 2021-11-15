package com.example.proyecto2.demo.web.controller;

import com.example.proyecto2.demo.domain.Product;
import com.example.proyecto2.demo.domain.Purchase;
import com.example.proyecto2.demo.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;


    @GetMapping("/all")
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Purchase>> getClient(@PathVariable("id") String clientId){
        return purchaseService.getByClientId(clientId);
    }

    @PostMapping("/save")
    public Purchase save(@RequestBody Purchase purchase){
        return  purchaseService.save(purchase);
    }

}
