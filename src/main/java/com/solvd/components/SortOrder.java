package com.solvd.components;

import lombok.Getter;

import java.util.Comparator;

@Getter
public enum SortOrder {
    A_TO_Z("Name (A to Z)", Comparator.comparing(ProductCatalog::getProductName)),
    Z_TO_A("Name (Z to A)", Comparator.comparing(ProductCatalog::getProductName).reversed()),
    PRICE_LOW_TO_HIGH("Price (low to high)", Comparator.comparing(ProductCatalog::getPriceInDouble)),
    PRICE_HIGH_TO_LOW("Price (high to low)", Comparator.comparing(ProductCatalog::getPriceInDouble).reversed());

    protected final String name;
    private final Comparator<ProductCatalog> comparator;

    SortOrder(String name, Comparator<ProductCatalog> comparator) {
        this.name = name;
        this.comparator = comparator;
    }
}