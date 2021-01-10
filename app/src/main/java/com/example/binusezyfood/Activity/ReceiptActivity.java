package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfood.Activity.ItemsActivity.DrinksActivity;
import com.example.binusezyfood.Balance.Balance;
import com.example.binusezyfood.History.History;
import com.example.binusezyfood.History.HistoryHolder;
import com.example.binusezyfood.Items.Item;
import com.example.binusezyfood.Items.ItemHolder;
import com.example.binusezyfood.R;
import com.example.binusezyfood.Receipt.AdapterReceipt;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReceiptActivity extends AppCompatActivity {
    ArrayList<Item> itemList = ItemHolder.getInstance().item;
    HistoryHolder historyHolder = HistoryHolder.getInstance();

    Balance balance = Balance.getInstance();
    AdapterReceipt adpItem;
    ListView itemListView;
    private double tempTotal;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Intent intent = getIntent();
        address = intent.getStringExtra(MapsActivity.ADDRESS);

        TextView textView = findViewById(R.id.textViewAddress);
        textView.setText(address);

        itemListView = (ListView)findViewById(R.id.listViewReceipt);
        TextView textViewTotalPrice = (TextView)findViewById(R.id.textViewTotalPrice);

        textViewTotalPrice.setText(getTotal());;
        adpItem = new AdapterReceipt(this, itemList);
        itemListView.setAdapter(adpItem);
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

    public void clickContinue(View view) {
        if(tempTotal > balance.getBalance()){
            Toast.makeText(this, "Saldo tidak cukup!", Toast.LENGTH_SHORT).show();
        }else{
            Date tempDate = Calendar.getInstance().getTime();
            String date = tempDate.toString().substring(0,19);

            historyHolder.history.add(new History(historyHolder.history.size(), address, date, itemList));
            historyHolder.history.get(historyHolder.history.size()-1).itemList.addAll(itemList);

            tempTotal = balance.getBalance() - tempTotal;
            balance.setBalance(tempTotal);

            itemList.clear();
            Toast toast = Toast.makeText(getApplicationContext(),"Pesanan telah di konfirmasi!", Toast.LENGTH_SHORT);toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}