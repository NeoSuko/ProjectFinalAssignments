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

public class SnacksActivity extends AppCompatActivity {
    public static final String ITEM = "com.example.binusezyfood.ITEM";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
    }


    public void clickFrenchFries(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "French Fries";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickSausage(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Sausage";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickSandwich(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Sandwich";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }

    public void clickKebab(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        String item = "Kebab";
        intent.putExtra(ITEM, item);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}