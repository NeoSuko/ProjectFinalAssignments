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

public class DrinksActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.binusezyfood.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
    }

    public void clickAirMineral(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Mineral Water";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickJusApel(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Apple Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickJusAlpukat(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Avocado Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickJusMangga(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Mango Juice";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}