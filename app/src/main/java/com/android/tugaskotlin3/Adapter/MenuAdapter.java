package com.android.tugaskotlin3.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tugaskotlin3.Model.Menu;
import com.android.tugaskotlin3.R;

import java.util.ArrayList;

public class MenuAdapter extends ArrayAdapter<Menu> {

    public MenuAdapter (Activity context, ArrayList<Menu> homes){
        super(context, 0,homes); }

    //getview method turunan dari ArrayAdapter fumgsinya mengambil view .

    public View getView (int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Menu currrentHome = getItem(position);
        TextView homeNameTextView = (TextView) listItemView.findViewById(R.id.home_name_text_view);

        homeNameTextView.setText(currrentHome.getHomeName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(Integer.toString(currrentHome.getHomePrice()));

        ImageView imageView= (ImageView)listItemView.findViewById(R.id.img);

        imageView.setImageResource(currrentHome.getmImageResouce());

        imageView.setVisibility(View.VISIBLE);
        return  listItemView;
    }
}