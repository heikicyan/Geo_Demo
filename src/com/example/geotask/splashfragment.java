package com.example.geotask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class splashfragment extends Fragment//create a style fragment for the splash 
{
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.splashfragment,container,false);
		return view;
	}
}