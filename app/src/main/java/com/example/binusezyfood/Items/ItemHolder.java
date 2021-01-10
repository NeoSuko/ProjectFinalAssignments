package com.example.binusezyfood.Items;

import java.util.ArrayList;

public class ItemHolder {
    public ArrayList<Item> item;
    private static ItemHolder instance;

    private ItemHolder(){
        item = new ArrayList<Item>();
    }

    public static ItemHolder getInstance(){
        if(instance == null){
            instance = new ItemHolder();
        }
        return instance;
    }
}
