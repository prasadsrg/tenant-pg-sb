package com.tenant.tenant.repository;

import com.tenant.tenant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Md. Amran Hossain
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
