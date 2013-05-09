package com.example.geotask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class mainfragment extends Fragment//create a style fragment for the Mainactivity
{
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.mainfragment,container,false);
		return view;
	}
}