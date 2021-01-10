package com.example.binusezyfood.Items;

import java.io.Serializable;

public class Item {
    private String name = "";
    private int quantity = 0;
    private int price = 0;
    private int historyId = -1;

    public Item(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(String name, int quantity, int price, int historyId) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.historyId = historyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHistoryId() { return historyId; }

    public void setHistoryId(int historyId) { this.historyId = historyId; }
}
