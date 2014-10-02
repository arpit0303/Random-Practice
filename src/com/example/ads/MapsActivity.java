package com.example.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Activity {

	GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);
		
		getActionBar().hide();
		
		Intent intent = getIntent();
		int map_type = intent.getIntExtra("map_type", 0);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		LatLng location = new LatLng(21.8675525, 75.963335);
		
		switch (map_type) {
		case 0:
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			break;
		case 1:
			map.setMapType(GoogleMap.MAP_TYPE_NONE);
			break;
		case 2:
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			break;
		case 3:
			map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			break;
		case 4:
			map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			break;

		default:
			break;
		}
		
		map.addMarker(new MarkerOptions()
					.position(location)
					.title("Gururaj Pagad Farm, Bangalore, Karnataka")
					.draggable(true)
					.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
					.snippet("Jaaga Study Program"));
		
		map.setMyLocationEnabled(true);
		
//		GroundOverlayOptions newarkMap = new GroundOverlayOptions()
//        .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
//        .anchor(0, 1)
//        .position(location, 0, 0);
//		
//		map.addGroundOverlay(newarkMap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.maps, menu);
		return true;
	}

}
