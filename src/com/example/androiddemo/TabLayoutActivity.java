package com.example.androiddemo;

import com.example.androiddemo.tab.GameActivity;
import com.example.androiddemo.tab.MoveActivity;
import com.example.androiddemo.tab.MusicActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class TabLayoutActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
 
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this,GameActivity.class);
 
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("game").setIndicator("Game",
                          res.getDrawable(R.drawable.ic_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
 
        // Do the same for the other tabs
        intent = new Intent().setClass(this, MoveActivity.class);
        spec = tabHost.newTabSpec("move").setIndicator("Move",
                          res.getDrawable(R.drawable.ic_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
 
        intent = new Intent().setClass(this, MusicActivity.class);
        spec = tabHost.newTabSpec("music").setIndicator("Music",
                          res.getDrawable(R.drawable.ic_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
 
        tabHost.setCurrentTab(2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_layout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
