package ru.arba.catalog.services;

import org.springframework.stereotype.Service;
import ru.arba.core.catalog.dto.ProductDTO;

@Service
public class ProductDTOMock {

    public ProductDTOMock(){
    }

    public ProductDTO getProductDTO(){
        return new ProductDTO();
    }
}
