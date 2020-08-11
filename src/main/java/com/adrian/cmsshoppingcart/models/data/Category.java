package com.adrian.cmsshoppingcart.models.data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Size(min=2, message = "Name must be at least 2 characters long")
    private String name;

    private String slug;
    
    private int sorting;

    public Category() {
    }

    public Category(@Size(min = 2, message = "Name must be at least 2 characters long") String name, String slug, int sorting) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
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

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}
