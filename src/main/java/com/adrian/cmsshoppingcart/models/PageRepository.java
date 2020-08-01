package com.adrian.cmsshoppingcart.models;

import com.adrian.cmsshoppingcart.models.data.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Integer> {

    List<Page> findAll();

    Page findBySlug(String slug);
}
