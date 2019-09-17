package com.company.DelcieDionU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    private int tshirtId;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    public TShirt() {
    }

    public TShirt(int tshirtId, String size, String color, String description, BigDecimal price, int quantity) {
        this.tshirtId = tshirtId;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getTshirtId() {
        return tshirtId;
    }

    public void setTshirtId(int tshirtId) {
        this.tshirtId = tshirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return tshirtId == tShirt.tshirtId &&
                quantity == tShirt.quantity &&
                size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description) &&
                price.equals(tShirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tshirtId, size, color, description, price, quantity);
    }
}
