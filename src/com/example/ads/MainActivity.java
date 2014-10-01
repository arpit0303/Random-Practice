package com.example.ads;

import com.appflood.AppFlood;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//AppFlood Ads
		AppFlood.initialize(this, "FgjL5kzJLhBBBp4W", "yMfUo8ml525aL541177fa",
				AppFlood.AD_SPLASH_SCREEN, Color.RED, Color.BLACK, Color.YELLOW);

		//Screen Resolution
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);

		String screenResolution = "Screen Resolution : " + dm.widthPixels + "*"
				+ dm.heightPixels;

		TextView resolution = (TextView) findViewById(R.id.textView3);
		resolution.setText(screenResolution);

		//Spinner
		Spinner spnr = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, 
				getResources().getStringArray(R.array.android));
		spnr.setAdapter(adapter);

		//CPU Info
		Button CPUInfo = (Button) findViewById(R.id.CPUInfo);
		CPUInfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						CPUInfoActivity.class);
				startActivity(intent);
			}
		});

		//System Info
		Button SYSInfo = (Button) findViewById(R.id.SYSInfo);
		SYSInfo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						SystemInfoActivity.class);
				startActivity(intent);
			}
		});
		
		//next activity
		Button next = (Button) findViewById(R.id.next);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						NextActivity.class);
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
