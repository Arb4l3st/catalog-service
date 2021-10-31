package ru.arba.core.catalog.dto;

import ru.arba.catalog.enums.CategoryEnum;

public class ProductDTO {
    private String key;
    private String name;
    private CategoryEnum category;
    private long cost;

    public ProductDTO(){}

    public ProductDTO(String key, String name, CategoryEnum category, long cost){
        this.key = key;
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
