package com.example.proyecto2.demo.web.controller;

import com.example.proyecto2.demo.domain.Product;
import com.example.proyecto2.demo.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 400, message = "Not Found")}
    )
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The product´s id", required = true,example = "30") @PathVariable("id") int productId){
        return productService.getProduct(productId).map(product -> new ResponseEntity<>(product,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/categeory/{id}")
    public Optional<List<Product>> getByCategory(@PathVariable("id")int categoryID){
            return productService.getByCategory(categoryID);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return  productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return  productService.delete(productId);
    }

}
