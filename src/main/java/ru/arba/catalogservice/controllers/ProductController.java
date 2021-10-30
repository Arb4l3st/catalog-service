package ru.arba.catalogservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arba.catalogservice.dto.ProductDTO;
import ru.arba.catalogservice.services.ProductDTOMock;

import java.util.Map;

@RestController
@RequestMapping("/api/card")
public class ProductController {

    private final Map<String, ProductDTOMock> catalog;

    public ProductController(Map<String, ProductDTOMock> catalog){
        this.catalog = catalog;
    }

    //занесение новой карточки
    @PutMapping(path="/create")
    public HttpStatus createCard(@RequestBody ProductDTOMock productDTOMock){
        ProductDTO productDTO = productDTOMock.getProductDTO();
        catalog.put(productDTO.getKey(), productDTOMock);
        return HttpStatus.OK;
    }

    //получение карточки
    //мэмэмэаэмээм  - а если такого в мапе нет? мэаэмэмэаэ
    @GetMapping(value = {"key"})
    public ResponseEntity<ProductDTOMock> getCard(@PathVariable("key") String key){
        return ResponseEntity.ok(catalog.get(key));
    }

    //изменение карточки
    @PostMapping(path="/update")
    public HttpStatus updateCard(@RequestBody ProductDTOMock productDTOMock){
        ProductDTO productDTO = productDTOMock.getProductDTO();
        if (catalog.containsKey(productDTO.getKey())){
            catalog.put(productDTO.getKey(), productDTOMock);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

}
