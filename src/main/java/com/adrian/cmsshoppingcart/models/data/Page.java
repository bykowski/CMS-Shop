package com.adrian.cmsshoppingcart.models.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="pages")
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String slug;
    private int sort;

}
