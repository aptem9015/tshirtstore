package com.example.tshirtstore.controllers;

import com.example.tshirtstore.entities.Product;
import com.example.tshirtstore.services.CategoryService;
import com.example.tshirtstore.services.ProducerService;
import com.example.tshirtstore.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class ProductController {

    private ProductService productService;
    private ProducerService producerService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, ProducerService producerService, CategoryService categoryService) {
        this.productService = productService;
        this.producerService = producerService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/{id}/one_product")
    public String showById(@PathVariable String id, Model model){
        productService.getProductById(new Long(id)).ifPresent(o -> model.addAttribute("product", o));
        return "one_product";
    }


    @GetMapping("/admin/products")
    public String indexAdmin(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin/products";
    }


    @GetMapping("/admin/add_product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("producers", producerService.getAllProducers());
        return "admin/add_product";
    }

    @PostMapping("/admin/add_product")
    public String addProductSubmit(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/add_product";
        } else {
            productService.saveProduct(product);
            return "redirect:/admin/products";
        }
    }

    @RequestMapping(value = "/imagedisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        Product item = productService.getProductById(itemId).get();
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.getImage());
        response.getOutputStream().close();
    }

    @RequestMapping(value = "/productcategory", method = RequestMethod.GET)
    public String showCategoryByIdProduct(@RequestParam("id") Long productId, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        return productService.getProductById(productId).get().getCategory().getNameCategory();
    }

    @RequestMapping(value = "/search/")
    public String findProductsByName(@RequestParam("search")String name, Model model) {
        model.addAttribute("products", this.productService.getProductByName(name));
        return "index";
    }

    @RequestMapping(value = "/sort/")
    public String findProductsByCategory(@RequestParam(value = "type")String type, Model model) {
        if (type.equals("all")){
            model.addAttribute("products", this.productService.getAllProducts());
        }else{
            model.addAttribute("products", this.productService.getProductsByCategory(new Long(type)));
        }

        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }

    @RequestMapping(value = "/{id}/del")
    public String delProductById(@PathVariable(value = "id") long id){
        productService.deleteById(id);
        return "redirect:/admin/products";
    }
}
