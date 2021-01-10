package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfood.Balance.Balance;
import com.example.binusezyfood.History.History;
import com.example.binusezyfood.History.HistoryHolder;
import com.example.binusezyfood.Items.AdapterItem;
import com.example.binusezyfood.Items.Item;
import com.example.binusezyfood.Items.ItemHolder;
import com.example.binusezyfood.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ArrayList<Item> itemList = ItemHolder.getInstance().item;
    ArrayList<History> historyList = HistoryHolder.getInstance().history;

    AdapterItem adpItem;
    ListView itemListView;
    Intent intent;
    private double tempTotal;
    Balance balance = Balance.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        itemListView = (ListView)findViewById(R.id.listView);
        TextView textViewTotalPrice = (TextView)findViewById(R.id.textViewTotalPrice);
        ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.constraintTotalPrice);

        TextView textViewBalance = findViewById(R.id.textViewBalance);

        double tempBalance = Balance.getInstance().getBalance();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String balance = kursIndonesia.format(tempBalance);
        textViewBalance.setText(balance);

        if(getIntent().getExtras() != null){
            intent = getIntent();
            String name = intent.getStringExtra(OrderActivity.NAME);

            String temp = intent.getStringExtra(OrderActivity.QUANTITY);
            int quantity = Integer.parseInt(temp);

            temp = intent.getStringExtra(OrderActivity.PRICE);
            int price = Integer.parseInt(temp);

            int historyId = historyList.size();
            itemList.add(new Item(name, quantity, price, historyId));

            textViewTotalPrice.setText(getTotal());
            adpItem = new AdapterItem(this, itemList);
            itemListView.setAdapter(adpItem);
        }else{
            if(itemList.isEmpty()){
                constraintLayout.setVisibility(View.GONE);
                Toast toast = Toast.makeText(getApplicationContext(),"Keranjang kosong!", Toast.LENGTH_SHORT);toast.show();
            }else{
                constraintLayout.setVisibility(View.VISIBLE);
                textViewTotalPrice.setText(getTotal());
                adpItem = new AdapterItem(this, itemList);
                itemListView.setAdapter(adpItem);
            }
        }
    }

    private String getTotal() {
        tempTotal = 0;
        String totalPrice = "";
        for(Item item: itemList){
            tempTotal += (item.getPrice()*item.getQuantity());
        }

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        totalPrice = kursIndonesia.format(tempTotal);

        return totalPrice;
    }

    public void clickPay(View view) {
        if(tempTotal > balance.getBalance()){
            Toast.makeText(this, "Saldo tidak cukup!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Mengambil lokasi anda...", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}