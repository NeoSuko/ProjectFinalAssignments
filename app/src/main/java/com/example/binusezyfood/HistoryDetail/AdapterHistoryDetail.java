package com.example.binusezyfood.HistoryDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.binusezyfood.Items.Item;
import com.example.binusezyfood.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class AdapterHistoryDetail extends BaseAdapter {
    Context context;
    ArrayList<Item> item = new ArrayList<>();

    Item tempItem;

    public AdapterHistoryDetail(Context context, ArrayList<Item> item) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.list_receipt, parent,false);
        }

        tempItem = (Item) getItem(position);

        TextView tvName = (TextView)convertView.findViewById(R.id.textViewItemList);
        TextView tvNumber = (TextView)convertView.findViewById(R.id.textViewQuantity);
        TextView tvPrice = (TextView)convertView.findViewById(R.id.textViewPrice) ;

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
