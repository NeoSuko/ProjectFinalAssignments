package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.binusezyfood.Activity.ItemsActivity.DrinksActivity;
import com.example.binusezyfood.Activity.ItemsActivity.SnacksActivity;
import com.example.binusezyfood.Activity.ItemsActivity.FoodsActivity;
import com.example.binusezyfood.Balance.Balance;
import com.example.binusezyfood.History.History;
import com.example.binusezyfood.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textViewBalance);

        double tempBalance = Balance.getInstance().getBalance();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String balance = kursIndonesia.format(tempBalance);
        textView.setText(balance);
    }

    public void clickDrinks(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void clickCart(View view) {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

    public void clickSnacks(View view) {
        Intent intent = new Intent(this, SnacksActivity.class);
        startActivity(intent);
    }

    public void clickFood(View view) {
        Intent intent = new Intent(this, FoodsActivity.class);
        startActivity(intent);
    }

    public void clickTopup(View view) {
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
    }

    public void clickHistory(View view){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
}