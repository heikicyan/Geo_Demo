package com.example.geotask;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customlist extends BaseAdapter { //create an custom adapter for listview

    private ArrayList _data;
    Context _c;
   
    customlist (ArrayList data, Context c){
        _data = data;
        _c = c;
    }
  
    public int getCount() {
        // TODO Auto-generated method stub
        return _data.size();
    }
   
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return _data.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
  
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
         View v = convertView;
         if (v == null)
         {
            LayoutInflater vi = (LayoutInflater)_c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.listcontent, null);
         }

           ImageView icon = (ImageView) v.findViewById(R.id.imageView1);
           TextView  place= (TextView)v.findViewById(R.id.textView1);
           TextView time = (TextView)v.findViewById(R.id.textView2);
           

           listdetails list = (listdetails) _data.get(position);
           icon.setImageResource(list.icon);
           place.setText(list.place);
           time.setText(list.time);
         
                    
         
                       
        return v;
}
}