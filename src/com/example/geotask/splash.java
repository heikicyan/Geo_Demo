package com.example.geotask;
import java.util.List;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class splash extends FragmentActivity
{   
	private BroadcastReceiver gpsreceiver;
    @Override
	public void onCreate(Bundle icicle)
	{
		super.onCreate(icicle);
        setContentView(R.layout.splash);
        Toast.makeText(this, "Please make sure the GPS service is open.", Toast.LENGTH_LONG).show();
        startService(new Intent("com.example.geotask.gpsservice"));//start the GPSservice
        IntentFilter intentFilter=new IntentFilter("com.example.geotask.gpsdata");
        gpsreceiver=new BroadcastReceiver()//get the broadcast from the GPSservice
        {
        	@Override 
        	public void onReceive(Context context, Intent intent)
        	{
                List<Integer> lat=intent.getIntegerArrayListExtra("lat");
        		if(lat.size()>=0)//when get the data, turn to the Mainactivity
        	{
        		
                Intent mainIntent = new Intent(splash.this, MainActivity.class);
                splash.this.startActivity(mainIntent);
                splash.this.finish();
                  
        	}
        	}
        
        };
        this.registerReceiver(gpsreceiver, intentFilter);
        
	}
}