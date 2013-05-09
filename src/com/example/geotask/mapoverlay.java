package com.example.geotask;

import java.util.ArrayList;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class mapoverlay extends ItemizedOverlay //create for the custom map overlay

{     Context mContext;
	private ArrayList<OverlayItem> mOverlays= new ArrayList<OverlayItem>();
	public mapoverlay(Drawable defaultMarker){
		super(boundCenterBottom(defaultMarker));
	}
	public void addOverlay(OverlayItem overlay){
		mOverlays.add(overlay);
		populate();
	}
	@Override
	protected OverlayItem createItem(int i)
	{
		return mOverlays.get(i);
	}
	@Override
	public int size() {
	  return mOverlays.size();
	}
	public mapoverlay(Drawable defaultMarker, Context context) {
		  super(boundCenterBottom(defaultMarker));
		 mContext = context;
		}
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}
}