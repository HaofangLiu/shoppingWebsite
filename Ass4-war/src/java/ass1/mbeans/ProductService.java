/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import java.util.List;

/**
 *
 * @author haofangliu
 */
public interface ProductService {
        
    List<Product> getProductsLists();

    Product getProduct(long id);
    
}
