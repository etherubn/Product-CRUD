package com.example.product.service;

import com.example.product.Exception.MiException;
import com.example.product.dto.MessageDto;
import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //READ
    public List<ProductDto> getProducts(){
        ObjectMapper mapper = new ObjectMapper();
        List<ProductDto> productsDto = productRepository.findAll().stream().map(
                product -> mapper.convertValue(product, ProductDto.class)
        ).collect(Collectors.toList());

        return productsDto;
    }
    //CREATE
    @Transactional
    public MessageDto createProduct(ProductDto productDto){
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        return new MessageDto("Product "+product.getDescription()+" created");
    }

    //UPDATE
    @Transactional
    public MessageDto updateProduct(ProductDto productDto, Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();

            product.setPrice(productDto.getPrice());
            product.setDiscount(productDto.getDiscount());
            product.setFinalPrice(productDto.getFinalPrice());
            product.setDescription(productDto.getDescription());
            product.setWeight(productDto.getWeight());
            product.setHeight(productDto.getHeight());
            product.setWidth(productDto.getWidth());
            product.setLength(productDto.getLength());
            product.setInitialStock(productDto.getInitialStock());
            product.setSoldUnits(productDto.getSoldUnits());
            product.setCurrentStock(productDto.getCurrentStock());
            productRepository.save(product);
        }else{
            throw new MiException("No existe producto con el id "+id);
        }
        return new MessageDto(productDto.getDescription()+" actualizado");
    }

    //DELETE
    @Transactional
    public MessageDto deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()){
            productRepository.delete(optionalProduct.get());
        }else{
            throw new MiException("No existe producto con el id "+id);
        }

        return new MessageDto("Producto "+optionalProduct.get().getDescription()+" eliminado");
    }
}
