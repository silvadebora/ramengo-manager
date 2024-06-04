package com.redventures.ramengo.admin.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "proteins")
public class Protein {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private BigDecimal price;

    public Protein() {
    }

    public Protein(Long id, String imageInactive, String imageActive, String name, String description, BigDecimal price) {
        this.id = id;
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Protein(String imageInactive, String imageActive, String name, String description, BigDecimal price) {
        this.imageInactive = imageInactive;
        this.imageActive = imageActive;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageInactive() {
        return imageInactive;
    }

    public void setImageInactive(String imageInactive) {
        this.imageInactive = imageInactive;
    }

    public String getImageActive() {
        return imageActive;
    }

    public void setImageActive(String imageActive) {
        this.imageActive = imageActive;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
