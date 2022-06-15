package com.example.tshirtstore.controllers;

import com.example.tshirtstore.entities.Producer;
import com.example.tshirtstore.services.ProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProducerController {

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }


    @GetMapping("/admin/")
    public String indexAdmin(Model model) {
        return "admin/admin_index";
    }

    @GetMapping("/admin/producers")
    public String showProducers(Model model) {
        model.addAttribute("producers", producerService.getAllProducers());
        return "admin/producer";
    }

    @GetMapping("/admin/add_producer")
    public String addProducer(Model model) {
        model.addAttribute("producer", new Producer());
        return "admin/add_producer";
    }

    @PostMapping("/admin/add_producer")
    public String addProducerSubmit(@Valid Producer producer, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_producer";
        } else {
            producerService.saveProducer(producer);
            return "redirect:/admin/producers";
        }
    }


}
