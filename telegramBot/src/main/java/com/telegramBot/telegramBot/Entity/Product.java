package com.telegramBot.telegramBot.Entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Category id_category;
    @Column(nullable = false, length = 50, unique = true )
    String name;
    @Column(nullable = false, length = 400)
    String description;
    @Column(nullable = false, length = 15, precision = 2)
    Double price;

    public Category getId_category() {
        return id_category;
    }

    public void setId_category(Category id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
