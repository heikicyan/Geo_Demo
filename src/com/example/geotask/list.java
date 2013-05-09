package com.example.geotask;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.maps.GeoPoint;

public class list extends Activity{ 
	 private ListView listView; 
	 ArrayList details = new ArrayList();
	 customlist Adapter = new customlist(details, this);
	
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        Intent intent=getIntent();//receive the data from Mainactivity
        final ArrayList<Integer> lat=intent.getIntegerArrayListExtra("lat");
        final ArrayList<Integer> lon=intent.getIntegerArrayListExtra("lon");
    	final ArrayList<String> position=intent.getStringArrayListExtra("data");
    	final ArrayList<String> time=intent.getStringArrayListExtra("time");
    	//final ArrayList<String> address=intent.getStringArrayListExtra("address");
        setContentView(R.layout.list); 
        listView = (ListView)findViewById(R.id.listView1); 
        customlist Adapter = new customlist(details, this);
        listView.setAdapter(Adapter);
        
        
        int i=0;
    	for(i=0;i<position.size();i++) //add address information item
    	{ 
    		listdetails Detail = new listdetails();
            Detail.setIcon(R.drawable.ic_launcher);
            Detail.setPlace("At:"+position.get(i));
            Detail.setTime(time.get(i));
            details.add(Detail);
          
    	}
    	
    	listView.setOnItemClickListener(new OnItemClickListener() //when the listview item is selected, turn to the map view.
    	{
    		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
    			Intent i=new Intent();
    			i.setClass(list.this, maptask.class);
         		i.putIntegerArrayListExtra("lat", (ArrayList<Integer>) lat);
         		i.putIntegerArrayListExtra("lon", (ArrayList<Integer>) lon);
         		i.putStringArrayListExtra("time", (ArrayList<String>)time);
        		i.putStringArrayListExtra("data", (ArrayList<String>) position);
        		startActivity(i);
			}
    	});
            
            
        	
        	
        	}
}
       
