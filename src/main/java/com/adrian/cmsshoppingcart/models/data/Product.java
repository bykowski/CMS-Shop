package com.adrian.cmsshoppingcart.models.data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=2, message = "Name must be at least 2 characters long")
    private String name;

    private String slug;

    @Size(min=5, message = "Description must be at least 5 characters long")
    private String description;

    private String image;

    @Pattern(regexp = "^[0-9]+([.][0-9]{1,2})?", message = "Expected format: 5, 5.99, 15, 15.99")
    private String price;

    @Pattern(regexp = "^[1-9][0-9]*", message = "Please choose a category")
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(@Size(min = 2, message = "Name must be at least 2 characters long") String name,
                   String slug, @Size(min = 5, message = "Description must be at least 5 characters long") String description,
                   String image, @Pattern(regexp = "^[0-9]+([.][0-9]{1,2})?", message = "Expected format: 5, 5.99, 15, 15.99") String price,
                   @Pattern(regexp = "^[1-9][0-9]*",
            message = "Please choose a category") String categoryId,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.image = image;
        this.price = price;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
