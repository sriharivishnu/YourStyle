package com.magnitudestudios.sriharivishnu.outfitters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> data;
    private static LayoutInflater inflater = null;

    public ImageAdapter(Context context, ArrayList<Integer> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Integer getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        vi = inflater.inflate(R.layout.row_list_item,null);
        TextView per1 = vi.findViewById(R.id.per1);
        TextView per2 = vi.findViewById(R.id.per2);
        int percentYes = (int) (Math.random()*101);
        int percentNo = 100-percentYes;
        per1.setText(Integer.toString(percentYes)+"%");
        per2.setText(Integer.toString(percentNo)+"%");
        ImageView image = vi.findViewById(R.id.myPic);
        image.setBackgroundResource(data.get(position));
        return vi;
    }
}
