/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author haofangliu
 */
@Named
@RequestScoped
public class ProductsLists {
    
    @Inject
    private ProductService productService;

    private List<Product> products;

    //initialize the productService
    //when the bean is created, postConstruc will be called automatically. 
    
    @PostConstruct
    public void initialize() {
        products = productService.getProductsLists();
    }

    public List<Product> getProducts() {
        return products;
    }
    
}
