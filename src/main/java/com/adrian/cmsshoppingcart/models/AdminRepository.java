package com.adrian.cmsshoppingcart.models;

import com.adrian.cmsshoppingcart.models.data.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsername(String username);
}
