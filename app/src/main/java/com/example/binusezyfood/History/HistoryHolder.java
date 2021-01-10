package com.example.binusezyfood.History;

import com.example.binusezyfood.Items.Item;

import java.util.ArrayList;

public class HistoryHolder {
    public ArrayList<History> history;
    public ArrayList<Item> item;
    private static HistoryHolder instance;

    private HistoryHolder(){
        history = new ArrayList<History>();
        item = new ArrayList<>();
    }

    public static HistoryHolder getInstance(){
        if(instance == null){
            instance = new HistoryHolder();
        }
        return instance;
    }
}
