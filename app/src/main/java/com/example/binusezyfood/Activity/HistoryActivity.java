package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.binusezyfood.History.AdapterHistory;
import com.example.binusezyfood.History.History;
import com.example.binusezyfood.History.HistoryHolder;
import com.example.binusezyfood.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    public static final String ID = "com.example.binusezyfood.ID";
    ArrayList<History> historyList = HistoryHolder.getInstance().history;

    AdapterHistory adpHistory;
    ListView historyListView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyListView = (ListView)findViewById(R.id.listViewHistory);

        if(historyList.isEmpty()){
            Toast.makeText(this, "Kamu belum melakukan transaksi!", Toast.LENGTH_SHORT).show();
        }else{
            adpHistory = new AdapterHistory(this, historyList);
            historyListView.setAdapter(adpHistory);
        }
    }
}