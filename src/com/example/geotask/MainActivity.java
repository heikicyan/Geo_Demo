package com.example.geotask;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {
    
	public  ArrayList<String> position1 = new ArrayList<String>(); 
	public  ArrayList<String> time1=new ArrayList<String>();
	public  ArrayList<String> address1=new ArrayList<String>();
	public  ArrayList<Integer> lat1= new ArrayList<Integer>(); 
	public  ArrayList<Integer> lon1= new ArrayList<Integer>(); 
	//define the list to store the data obtained from GPSservice
    private BroadcastReceiver gpsreceiver;
    //define the BroadcastReceiver
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilter=new IntentFilter("com.example.geotask.gpsdata");
        gpsreceiver=new BroadcastReceiver()//BroadcastReceiver gets the broadcast from GPSservice
        {
        	@Override 
        	public void onReceive(Context context, Intent intent)
        	{
        	 position1=intent.getStringArrayListExtra("data");
        	 lat1=intent.getIntegerArrayListExtra("lat");
        	 lon1=intent.getIntegerArrayListExtra("lon");
        	 time1=intent.getStringArrayListExtra("time");
        	// address1=intent.getStringArrayListExtra("address");
        	}
        
        };
        this.registerReceiver(gpsreceiver, intentFilter);
        final Button mapbutton=(Button) findViewById(R.id.map);//define the map button, and set the intent.
        mapbutton.setOnClickListener(new OnClickListener(){
         	public void onClick(View v){
         		Intent intent =new Intent();
         		intent.setClass(MainActivity.this, maptask.class);
         		intent.putIntegerArrayListExtra("lat", (ArrayList<Integer>) lat1);
         		intent.putIntegerArrayListExtra("lon", (ArrayList<Integer>) lon1);
         		intent.putStringArrayListExtra("data", (ArrayList<String>) position1);
        		intent.putStringArrayListExtra("time", (ArrayList<String>) time1);
        		//intent.putStringArrayListExtra("address", (ArrayList<String>) address1);

         	//deliver the data obtained from GPSservice to the maptask activity by clicking the button

         		startActivity(intent);
         		
         	}
         });
        final Button listbutton=(Button) findViewById(R.id.list);
        listbutton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent =new Intent();
        		intent.setClass(MainActivity.this, list.class);
        		intent.putIntegerArrayListExtra("lat", (ArrayList<Integer>) lat1);
         		intent.putIntegerArrayListExtra("lon", (ArrayList<Integer>) lon1);
         		intent.putStringArrayListExtra("data", (ArrayList<String>) position1);
        		intent.putStringArrayListExtra("time", (ArrayList<String>) time1);
        		//intent.putStringArrayListExtra("address", (ArrayList<String>) address1);

        		startActivity(intent);
           //deliver the data obtained from GPSservice to the list activity by clicking the button
  	
        	}
        });
    	}

    public boolean onCreateOptionsMenu(Menu menu){  //create two menu items
	     menu.add(0,0,1,R.string.menu_exit); 
	     menu.add(0,1,0,R.string.about);
	     return super.onCreateOptionsMenu(menu);
	     
	    }

	public boolean onOptionsItemSelected(MenuItem menuItem){
		//super.onOptionsItemSelected(menuItem);
		switch (menuItem.getItemId())
		{
		case 0: showIsExit();
		break;
		case 1: showAbout();
        break;
		}
	
		

	   return false; 
	}
	
public void showAbout()//function of menuitem about
{
	new AlertDialog.Builder(this).setTitle(R.string.about).setMessage(R.string.AboutContent).show();
	
}

	public void showIsExit()//function of menuitem exit
	{
		 new AlertDialog.Builder(this).setTitle(R.string.title).setMessage(R.string.exit_text).setNegativeButton(R.string.exit_cancel, new DialogInterface.OnClickListener(){  
	         public void onClick(DialogInterface dialog, int which) {  
	         }  
	     }).setPositiveButton(R.string.enter, new DialogInterface.OnClickListener(){  
	           
	         public void onClick(DialogInterface dialog, int which) {  
	             /** ÍË³ö³ÌÐò*/  
	             finish();  
	         }  
	     }).show();  
	 }
}
	