package com.example.geotask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class maptask extends MapActivity {
	
	@Override
	
	
	protected boolean isRouteDisplayed() {
	    return false;
	}


	
	  @Override
	  public void onCreate(Bundle icicle) {//get the data from intent()
	

	    super.onCreate(icicle);
		Intent intent= getIntent();
	
		
		final ArrayList<Integer> x=intent.getIntegerArrayListExtra("lat");
		final ArrayList<Integer> y=intent.getIntegerArrayListExtra("lon");
		//final ArrayList<String> add=intent.getStringArrayListExtra("address");
		final ArrayList<String> add=intent.getStringArrayListExtra("data");

		final ArrayList<String> time=intent.getStringArrayListExtra("time");
	    setContentView(R.layout.map);  
	    
	  
	    
	    MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	    List<Overlay> mapOverlays = mapView.getOverlays();
	  
	    Drawable drawable = this.getResources().getDrawable(R.drawable.arrow);
	    mapoverlay itemizedoverlay = new mapoverlay(drawable, this);

	    int a=0, b=0;
	    for(a=0; a<x.size();a++)
		
			for(b=0; b<y.size(); b++)//add the item to the overlay list
			{
				if(a==b)
				{
					GeoPoint Point =new GeoPoint(x.get(a),y.get(b));
					
					OverlayItem overlayitem = new OverlayItem(Point, "Hello!", "I have been in "+add.get(a));
					mapOverlays.add(itemizedoverlay);
					itemizedoverlay.addOverlay(overlayitem);
		
	          }
         
	    }
	    
	  }
}

