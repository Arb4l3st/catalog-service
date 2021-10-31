package ru.arba.catalog.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arba.core.catalog.dto.ProductDTO;
import ru.arba.catalog.services.ProductDTOMock;

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
    public HttpStatus createCard(@RequestBody ProductDTOMock productDTOMock){ // Тут следует возвращать так-же ResponseEntity (ResponseEntity.ok().build() )
        ProductDTO productDTO = productDTOMock.getProductDTO();
        catalog.put(productDTO.getKey(), productDTOMock);
        return HttpStatus.OK;
    }

    //получение карточки
    //мэмэмэаэмээм  - а если такого в мапе нет? мэаэмэмэаэ
    @GetMapping(value = {"key"}) // фигурные скобки для переменных пути указывают внутри кавычек: "{key}"
    public ResponseEntity<ProductDTOMock> getCard(@PathVariable("key") String key){
        return ResponseEntity.ok(catalog.get(key));
    }

    //изменение карточки
    @PostMapping(path="/update")
    public HttpStatus updateCard(@RequestBody ProductDTOMock productDTOMock){ // Тут следует возвращать так-же ResponseEntity
        ProductDTO productDTO = productDTOMock.getProductDTO();
        if (catalog.containsKey(productDTO.getKey())){
            catalog.put(productDTO.getKey(), productDTOMock);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

}
