package com.example.tshirtstore.services;

import com.example.tshirtstore.entities.Producer;
import com.example.tshirtstore.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private ProducerRepository producerRepository;

    @Autowired
    public void setRepository(ProducerRepository repository) {
        this.producerRepository = repository;
    }

    public void saveProducer(Producer producer) {
        producerRepository.save(producer);
    }

    public List<Producer> getAllProducers() {
        return producerRepository.findAll();
    }

}