package com.example.binusezyfood.Items;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.binusezyfood.Activity.CartActivity;
import com.example.binusezyfood.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class AdapterItem extends BaseAdapter {
    Context context;
    ArrayList<Item> item = new ArrayList<>();

    public AdapterItem(Context context, ArrayList<Item> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        }

        Item tempItem = (Item) getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.textViewItemList);
        TextView tvNumber = (TextView)convertView.findViewById(R.id.textViewQuantity);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.textViewPrice) ;
        Button buttonDelete = (Button)convertView.findViewById(R.id.buttonDelete);

        buttonDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Item itemRemove = item.get(position);
                item.remove(itemRemove);

                Intent intent = new Intent(context,CartActivity.class);
                context.startActivity(intent);
            }
        });

        String quantity = String.valueOf(tempItem.getQuantity());

        double harga = tempItem.getPrice();

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        String price = kursIndonesia.format(harga);

        tvName.setText(tempItem.getName());
        tvNumber.setText(quantity);
        tvPrice.setText(price);

        return convertView;
    }
}
