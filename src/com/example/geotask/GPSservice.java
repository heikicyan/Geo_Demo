package com.example.geotask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import android.location.Geocoder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;

public class GPSservice extends Service
{
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	public  ArrayList<String> position = new ArrayList<String>(); 
	public  ArrayList<String> time=new ArrayList<String>();
	public  ArrayList<String> address=new ArrayList<String>();
	public  ArrayList<Integer> lat= new ArrayList<Integer>(); 
    public  ArrayList<Integer> lon= new ArrayList<Integer>(); 
public void onCreate()
{
	super.onCreate();
	
	
}
public void onStart(Intent intent, int startID)
{LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
String provider = locationManager.GPS_PROVIDER;
Location location = locationManager.getLastKnownLocation(provider);
locationManager.requestLocationUpdates(provider, 2000, 10, locationListener);
}
private void additem(Location location){
	 String latLongString = "Lat:" + location.getLatitude() + "\nLong:" + location.getLongitude();
	 position.add(latLongString);
	 Calendar now=Calendar.getInstance();
	 int hours=now.get(Calendar.HOUR);
	 int minitues=now.get(Calendar.MINUTE);
	 int seconds=now.get(Calendar.SECOND);
	 String timeString="Time:"+hours+":"+minitues+":"+seconds;
	 time.add(timeString);
	 
}

private void addgeo(Location location){
	int x=(int)location.getLatitude()*1000000;
	int y=(int)location.getLongitude()*1000000;
	lat.add(x);
	lon.add(y);
	/*String add;
	Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
    try {    
            List<Address> addresses = geoCoder.getFromLocation(
                            location.getLatitude(), location.getLongitude(),
                            1);
             add = addresses.get(0).getAddressLine(0);
            
    } catch (IOException e) {
            add = "";
            e.printStackTrace();
    }
	address.add(add);
	*/
	
}
 


LocationListener locationListener = new LocationListener() {
		public void onLocationChanged(Location location) {
			additem(location);
	    	addgeo(location);
	   	    String latLongString = "Lat:" + location.getLatitude() + "\nLong:" + location.getLongitude();
			Intent intent= new Intent("com.example.geotask.gpsdata");
			intent.putIntegerArrayListExtra("lat", (ArrayList<Integer>) lat);
    		intent.putIntegerArrayListExtra("lon", (ArrayList<Integer>) lon);
    		intent.putStringArrayListExtra("data", (ArrayList<String>) position);
    		intent.putStringArrayListExtra("time", (ArrayList<String>) time);
    		//intent.putStringArrayListExtra("address", address);
			
    		sendBroadcast(intent);    }
		
	     // updateWithNewLocation(location);
	  
		   
//	    	addlayout(location);
	   
	   
	    public void onProviderDisabled(String provider){
	      //updateWithNewLocation(null);
	  //  	addlayout(null);

	    }

	    public void onProviderEnabled(String provider) {
	    	//updateWithNewLocation(null);
	    //	addlayout(null);

	    }

	    public void onStatusChanged(String provider, int status, Bundle extras) {}
	  };
	    
	
	     


}