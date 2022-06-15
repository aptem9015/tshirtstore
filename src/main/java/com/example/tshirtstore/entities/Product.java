package com.example.tshirtstore.entities;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.IOException;
import java.util.List;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_producer", nullable = false)
    private Producer producer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;


    @Column(name = "name_of_product")
    private String nameProduct;
    private Float price;
    @Column(name = "male_female")
    private String male_female;
    private String sizes;
    private byte[] image;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Product(Producer producer, Category category, String nameProduct, Float price, String male_female, String sizes, MultipartFile image) throws IOException {
        this.producer = producer;
        this.category = category;
        this.nameProduct = nameProduct;
        this.price = price;
        this.male_female = male_female;
        this.sizes = sizes;
        setImage(image);
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getMale_female() {
        return male_female;
    }

    public void setMale_female(String male_female) {
        this.male_female = male_female;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(MultipartFile image) throws IOException {
        this.image = image.getBytes();
    }
}
