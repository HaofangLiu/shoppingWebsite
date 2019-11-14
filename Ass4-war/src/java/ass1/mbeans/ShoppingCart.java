/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author haofangliu
 */
@Named
@SessionScoped
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<ShoppingCartLine> lines = new ArrayList<>();

    private int totalQuantity = 0;

    private double totalAmount;

    

    public List<ShoppingCartLine> getLines() {
        return lines;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product) {
        // Find the line for this product, increment quantity and amount if found
        for (ShoppingCartLine line : lines) {
            if (line.getProduct().getId() == product.getId()) {
                line.incrementQuantityAndAmount();
                incrementTotalQuantityAndAmount(line.getProduct().getPrice());
                return;
            }
        }

        // No line for this product yet, add a new line
        lines.add(new ShoppingCartLine(product));
        incrementTotalQuantityAndAmount(product.getPrice());
    }

    public void removeProduct(Product product) {
        Iterator<ShoppingCartLine> it = lines.iterator();
        while (it.hasNext()) {
            ShoppingCartLine line = it.next();

            // If this is the line for this product, decrement quantity and amount;
            // remove the line if the quantity has become 0
            if (line.getProduct().getId() == product.getId()) {
                if (line.decrementQuantityAndAmount()) {
                    it.remove();
                }

                decrementTotalQuantityAndAmount(product.getPrice());
            }
        }
    }

    private void incrementTotalQuantityAndAmount(double productPrice) {
        totalQuantity++;
        totalAmount = totalAmount + productPrice;
    }

    private void decrementTotalQuantityAndAmount(double productPrice) {
        totalQuantity--;
        totalAmount = totalAmount - productPrice;
    }
}
