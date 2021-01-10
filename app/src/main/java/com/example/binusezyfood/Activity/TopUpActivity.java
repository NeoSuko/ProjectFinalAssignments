package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfood.Balance.Balance;
import com.example.binusezyfood.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TopUpActivity extends AppCompatActivity {
    Balance balance = Balance.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

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


    public void clickAddBalance(View view) {
        EditText editText =  findViewById(R.id.editTextAmount);

        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this, "Masukan jumlah yang di inginkan!", Toast.LENGTH_SHORT).show();
        }else{
            double amount = Double.parseDouble(editText.getText().toString());
            if(amount > 2000000){
                Toast.makeText(this, "Tidak bisa memasukan lebih dari 2 juta", Toast.LENGTH_SHORT).show();
            }else if(amount < 1){
                Toast.makeText(this, "Masukan jumlah yang di inginkan!", Toast.LENGTH_SHORT).show();
            } else{
                amount += balance.getBalance();
                balance.setBalance(amount);
                Toast.makeText(this, "Saldo berhasil di tambahkan!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TopUpActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}