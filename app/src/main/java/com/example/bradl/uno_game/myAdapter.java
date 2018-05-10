package com.example.bradl.uno_game;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bradl on 5/10/2018.
 * this adapter is used for Gridview.
 */

public class myAdapter extends BaseAdapter {
    Context myContext;
    ArrayList<Integer> color;
    ArrayList<Integer> number;

    public myAdapter(Context myContext, ArrayList<Integer> color, ArrayList<Integer> number){
        this.myContext = myContext;
        this.color = color;
        this.number = number;
    }

    @Override
    public int getCount() {
        return color.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView eachView = new TextView(myContext);
        eachView.setText(Integer.toString(number.get(position)));
        eachView.setGravity(Gravity.CENTER);
        eachView.setTextSize(60);
        eachView.setTextColor(Color.WHITE);
        eachView.setBackgroundColor(color.get(position));
        eachView.setHeight(320);
        return eachView;
    }
}
