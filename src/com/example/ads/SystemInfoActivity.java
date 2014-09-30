package com.example.ads;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SystemInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system_info);
		// Show the Up button in the action bar.
		setupActionBar();
		
		TextView SysInfo = (TextView) findViewById(R.id.SysInfo);
		SysInfo.setText(ReadSYSinfo());
	}

	private static StringBuffer SYSinfoBuffer;

	 private String ReadSYSinfo()
	 {
	  SYSinfoBuffer = new StringBuffer();
	  
	  getProperty("os.name", "os.name", SYSinfoBuffer);
	  getProperty("os.version", "os.version", SYSinfoBuffer);
	  
	  getProperty("java.vendor.url", "java.vendor.url", SYSinfoBuffer);
	  getProperty("java.version", "java.version", SYSinfoBuffer);
	  getProperty("java.class.path", "java.class.path", SYSinfoBuffer);
	  getProperty("java.class.version", "java.class.version", SYSinfoBuffer);
	  getProperty("java.vendor", "java.vendor", SYSinfoBuffer);
	  getProperty("java.home", "java.home", SYSinfoBuffer);
	  
	  getProperty("user.name", "user.name", SYSinfoBuffer);
	  getProperty("user.home", "user.home", SYSinfoBuffer);
	  getProperty("user.dir", "user.dir", SYSinfoBuffer);
	  
	  return SYSinfoBuffer.toString();
	 }

	 private void getProperty(String desc, String property, StringBuffer tBuffer)
	 {
	  tBuffer.append(desc);
	  tBuffer.append(" : ");
	  tBuffer.append(System.getProperty(property));
	  tBuffer.append("\n");
	 }
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.system_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
