/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manu.database;
import com.manu.cashregister.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manu
 */
public class Database {
    private final Product[] products;
    private final int productsSize;
    private final List<Product> purchases;
    private final List<Product> sales;
    
    public Database() {
        this.productsSize = 3;
        this.products = new Product[this.productsSize];
        this.products[0] = new Product(0, "Arroz primor", 20, 50);
        this.products[1] = new Product(1, "Papa", 10, 30);
        this.products[2] = new Product(2, "Carne Best", 50, 25);
        this.purchases = new ArrayList<>();
        this.sales = new ArrayList<>();
    }
    
    public Product getByIndex(int i) {
        if(i < 0 || i > this.productsSize - 1) {
            System.out.println("invalid index");
            return null;
        }
        
        Product result = null;
        
        try {
            result = this.products[i].clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public Product[] getProducts() {
        Product[] result = new Product[this.productsSize];
        for (int i = 0; i < this.productsSize; i++) {
            try {
                result[i] = this.products[i].clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                result[i] = null;
            }
        }
        return result;
    }
    
    public List<Product> getPurchases() {
        ArrayList<Product> result = new ArrayList<>();
        
        for (int i = 0; i < this.purchases.size(); i++) {
            try {
                result.add(this.purchases.get(i).clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                result.add(null);
            }
        }
        return result;
    }
    
    public List<Product> getSales() {
        ArrayList<Product> result = new ArrayList<>();
        
        for (int i = 0; i < this.sales.size(); i++) {
            try {
                result.add(this.sales.get(i).clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                result.add(null);
            }
        }
        return result;
    }
    
    public void buy(Product p) {
        Product tmp = this.products[p.getId()];

        tmp.setPrice(p.getPrice());
        tmp.setQty(tmp.getQty() + p.getQty());
        this.purchases.add(p);
    }
    
    public void sell(Product p) {
        Product tmp = this.products[p.getId()];

        p.setPrice((float) (p.getPrice() * 1.25));
        tmp.setQty(tmp.getQty() - p.getQty());
        this.sales.add(p);
    }
}
