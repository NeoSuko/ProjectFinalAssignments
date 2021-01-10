package com.example.binusezyfood.Activity.ItemsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.binusezyfood.Activity.CartActivity;
import com.example.binusezyfood.Activity.HistoryActivity;
import com.example.binusezyfood.Activity.MainActivity;
import com.example.binusezyfood.Activity.OrderActivity;
import com.example.binusezyfood.R;

public class FoodsActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.binusezyfood.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
    }

    public void clickHamburger(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Burger";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickPizza(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Pizza";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickSpagetti(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Spagetti";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickLasagna(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Lasagna";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}