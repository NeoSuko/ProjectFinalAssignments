package com.example.binusezyfood.HistoryDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfood.Activity.HistoryActivity;
import com.example.binusezyfood.History.History;
import com.example.binusezyfood.History.HistoryHolder;
import com.example.binusezyfood.HistoryDetail.AdapterHistoryDetail;
import com.example.binusezyfood.Items.Item;
import com.example.binusezyfood.Items.ItemHolder;
import com.example.binusezyfood.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class HistoryDetailActivity extends AppCompatActivity {

    AdapterHistoryDetail adpItem;
    ListView itemListView;

    ArrayList<History> historyList = HistoryHolder.getInstance().history;
    ArrayList<Item> itemList = new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        TextView textViewDate = findViewById(R.id.textViewTransactionDate);
        TextView textViewAddress = findViewById(R.id.textViewAddress);
        TextView textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        intent = getIntent();
        int id = intent.getIntExtra(HistoryActivity.ID, 0);

        itemList = historyList.get(id).itemList;

        textViewDate.setText(historyList.get(id).getDate());
        textViewAddress.setText(historyList.get(id).getAddress());
        textViewTotalPrice.setText(getTotal());

        itemListView = (ListView)findViewById(R.id.listViewHistoryDetail);
        adpItem = new AdapterHistoryDetail(this, itemList);
        itemListView.setAdapter(adpItem);
    }

    private String getTotal() {
        double tempTotal = 0;
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
}