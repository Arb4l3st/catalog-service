package ru.arba.catalogservice.services;

import org.springframework.stereotype.Service;
import ru.arba.catalogservice.dto.ProductDTO;

@Service
public class ProductDTOMock {

    public ProductDTOMock(){
    }

    public ProductDTO getProductDTO(){
        return new ProductDTO();
    }
}
