package com.example.tshirtstore.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

    @Column(name = "size")
    private int size;

    @Column(name = "fio_buyer")
    private String fio;
    @Column(name = "country_of_buyer")
    private String country;
    @Column(name = "city_of_buyer")
    private String city;
    @Column(name = "adress_of_buyer")
    private String adress;
    @Column(name = "email_of_buyer")
    private String email;
    @Column(name = "phone_of_buyer")
    private int phone;


    public Order(Product product, int size, String fio, String country, String city, String adress, String email, int phone) {
        this.product = product;
        this.size = size;
        this.fio = fio;
        this.country = country;
        this.city = city;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
