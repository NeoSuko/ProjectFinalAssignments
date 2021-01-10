package com.example.binusezyfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfood.Activity.ItemsActivity.DrinksActivity;
import com.example.binusezyfood.R;

public class OrderActivity extends AppCompatActivity {
    public static final String QUANTITY = "com.example.binusezyfood.QUANTITY";
    public static final String NAME = "com.example.binusezyfood.NAME";
    public static final String PRICE = "com.example.binusezyfood.PRICE";

    public String name = "";
    public String price = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String item = intent.getStringExtra(DrinksActivity.ITEM);

        TextView textView = findViewById(R.id.textViewItem);
        textView.setText(item);

        TextView textPrice = findViewById(R.id.textViewPrice);

        if(item.equals("Mineral Water")){
            name = item;
            textPrice.setText("Rp5.000");
            price = "5000";
        }else if(item.equals("Apple Juice")){
            name = item;
            textPrice.setText("Rp12.000");
            price = "12000";
        }else if(item.equals("Mango Juice")){
            name = item;
            textPrice.setText("Rp12.000");
            price = "12000";
        }else if(item.equals("Avocado Juice")){
            name = item;
            textPrice.setText("Rp12.000");
            price = "12000";
        }else if(item.equals("French Fries")){
            name = item;
            textPrice.setText("Rp20.000");
            price = "20000";
        }else if(item.equals("Sausage")){
            name = item;
            textPrice.setText("Rp15.000");
            price = "15000";
        }else if(item.equals("Sandwich")){
            name = item;
            textPrice.setText("Rp18.000");
            price = "18000";
        }else if(item.equals("Kebab")){
            name = item;
            textPrice.setText("Rp22.000");
            price = "22000";
        }else if(item.equals("Burger")){
            name = item;
            textPrice.setText("Rp40.000");
            price = "40000";
        }else if(item.equals("Pizza")){
            name = item;
            textPrice.setText("Rp35.000");
            price = "35000";
        }else if(item.equals("Spagetti")){
            name = item;
            textPrice.setText("Rp21.000");
            price = "21000";
        }else if(item.equals("Lasagna")){
            name = item;
            textPrice.setText("Rp33.000");
            price = "33000";
        }
    }

    public void clickAddToCart(View view) {
        Intent intent = new Intent(this, CartActivity.class);
        EditText editText = findViewById(R.id.editTextQuantity);
        String quantity = editText.getText().toString();

        if(quantity.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(),"Minimal masukan 1 item",Toast.LENGTH_SHORT);toast.show();
        }else if(Integer.parseInt(quantity) < 1) {
            Toast toast = Toast.makeText(getApplicationContext(),"Minimal masukan 1 item",Toast.LENGTH_SHORT);toast.show();
        } else {
            intent.putExtra(NAME, name);
            intent.putExtra(QUANTITY, quantity);
            intent.putExtra(PRICE, price);

            startActivity(intent);
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}