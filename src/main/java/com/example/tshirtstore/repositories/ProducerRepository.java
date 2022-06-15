package com.example.tshirtstore.repositories;

import com.example.tshirtstore.entities.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
