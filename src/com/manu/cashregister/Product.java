/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manu.cashregister;

public class Product implements Cloneable {
    private int id;
    private int qty;
    public String name;
    private float price;
    
    public Product() {}
    
    public Product(int id, String n, float p, int q) {
        this.id = id;
        this.name = n;
        this.qty = q;
        this.price = p;
    }
    
    @Override
    public String toString() {
        return this.name + " - " + this.price + " - " + this.qty;
    }
    
    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int q) {
        this.qty = q;
    }
    
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float p) {
        this.price = p;
    }
}
