/*
 author Anastasiya
 created on 15/07/2021
 */


package com.example.product.service.productService;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductHandlerImpl implements ProductHandler {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = convertFromDto(productDTO);
        return productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    private Product convertFromDto(ProductDTO productDTO) {
      return modelMapper.map(productDTO, Product.class);
    }
}
