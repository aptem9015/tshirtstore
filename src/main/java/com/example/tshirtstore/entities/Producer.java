package com.example.tshirtstore.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producers")
public class Producer {

    @Id
    @Column(name = "id_producer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_of_producer")
    private String nameProducer;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Column(name = "country_of_producer")
    private String countryProducer;

    @Column(name = "adress_of_producer")
    private String adressProducer;

    @Column(name = "email_of_producer")
    private String emailProducer;

    @Column(name = "phone_of_producer")
    private String phoneProducer;


    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private List<Product> products;

    public Producer() {

    }

    public Producer(String nameProducer, String countryProducer, String adressProducer, String emailProducer, String phoneProducer) {
        this.nameProducer = nameProducer;
        this.countryProducer = countryProducer;
        this.adressProducer = adressProducer;
        this.emailProducer = emailProducer;
        this.phoneProducer = phoneProducer;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getCountryProducer() {
        return countryProducer;
    }

    public void setCountryProducer(String countryProducer) {
        this.countryProducer = countryProducer;
    }

    public String getAdressProducer() {
        return adressProducer;
    }

    public void setAdressProducer(String adressProducer) {
        this.adressProducer = adressProducer;
    }

    public String getEmailProducer() {
        return emailProducer;
    }

    public void setEmailProducer(String emailProducer) {
        this.emailProducer = emailProducer;
    }

    public String getPhoneProducer() {
        return phoneProducer;
    }

    public void setPhoneProducer(String phoneProducer) {
        this.phoneProducer = phoneProducer;
    }
}
