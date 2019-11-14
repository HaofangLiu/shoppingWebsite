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
public class ShoppingCartLine {
    private Product product;
    private int quantity;
    private double amount;

    public ShoppingCartLine(Product product) {
        this.product = product;
        this.quantity = 1;
        this.amount = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void incrementQuantityAndAmount() {
        quantity++;
        amount = amount + product.getPrice();
    }

    public boolean decrementQuantityAndAmount() {
        quantity--;
        amount = amount - product.getPrice();
        return quantity == 0;
    }
}

