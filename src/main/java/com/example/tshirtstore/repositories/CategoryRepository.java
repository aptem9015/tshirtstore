package com.example.tshirtstore.repositories;

import com.example.tshirtstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
