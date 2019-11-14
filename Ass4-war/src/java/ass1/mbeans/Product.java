/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

/**
 *
 * @author haofangliu
 */
import java.io.Serializable;

public final class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long id;
    private final String name;
    private final double price;
    private final String desc;
    private final String imageName;

    public Product(long id, String name, double price,String desc,String imageName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.imageName = imageName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String getImageName(){
        return imageName;
    }

}
