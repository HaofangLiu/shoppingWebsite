/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

    private final Map<Long, Product> products;

    private final List<Product> allProducts;

    public ProductServiceImpl() {
        Map<Long, Product> map = new HashMap<>();
        map.put(1L, new Product(1L, "Single", 25.00,"For single person in one round traveling","1"));
        map.put(2L, new Product(2L, "double", 45.00,"For couples with one round of traveling","2"));
        map.put(3L, new Product(3L, "Family", 85.00,"Enjoy with your family!(for four persons)","3"));
        map.put(4L, new Product(4L, "Group", 210.00,"Enjoy this travel with your friends!(10 people only)","4"));
        
        products = Collections.unmodifiableMap(map);
        allProducts = Collections.unmodifiableList(new ArrayList<>(products.values()));
    }

    @Override
    public List<Product> getProductsLists() {
        return allProducts;
    }

    @Override
    public Product getProduct(long id) {
        return products.get(id);
    }
}
