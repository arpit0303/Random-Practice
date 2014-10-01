package com.example.ads;

import org.apache.http.util.LangUtils;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;

public class AnimatedListActivity extends ListActivity {

	String[] COUNTRIES = {"india","USA","Pakistan","China"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animated_list);
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, COUNTRIES));
		getListView().setTextFilterEnabled(true);
		

//		LayoutAnimationController controller = AnimationUtils
//				.loadLayoutAnimation(this, R.anim.list_layout_controller);
//		getListView().setLayoutAnimation(controller);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animated_list, menu);
		return true;
	}

}
