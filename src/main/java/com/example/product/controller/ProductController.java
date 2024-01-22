package com.example.product.controller;

import com.example.product.dto.MessageDto;
import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Lista de Productos
    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    //Creación de producto
    @PostMapping("")
    public ResponseEntity<MessageDto> createProduct(@RequestBody @Valid ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> updateProduct(@RequestBody @Valid ProductDto productDto,@PathVariable Long id){
        return new ResponseEntity<>(productService.updateProduct(productDto,id),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }

}
