package com.example.binusezyfood.History;

import com.example.binusezyfood.Items.Item;
import com.example.binusezyfood.Items.ItemList;

import java.util.ArrayList;

public class History {
    private int historyId;
    private String address;
    private String date;
    public ArrayList<Item> itemList;

    public History(int historyId, String address, String date, ArrayList<Item> itemList) {
        this.historyId = historyId;
        this.address = address;
        this.date = date;

        itemList = new ArrayList<>();
        this.itemList = itemList;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
