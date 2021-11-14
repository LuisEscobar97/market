package com.example.proyecto2.demo.domain;

public class PurchaseItem {

    private int pruductId;
    private int quantity;
    private double total;
    private boolean active;

    public PurchaseItem(int pruductId, int quantity, double total, boolean active) {
        this.pruductId = pruductId;
        this.quantity = quantity;
        this.total = total;
        this.active = active;
    }

    public PurchaseItem() {
    }

    public int getPruductId() {
        return pruductId;
    }

    public void setPruductId(int pruductId) {
        this.pruductId = pruductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
