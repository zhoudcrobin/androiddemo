package com.example.androiddemo;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils.TruncateAt;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.groups);  
		BorderTextView tv = new BorderTextView(this);
         tv.setText("android 演示模拟");
         tv.setTextSize(28);
         tv.setBackgroundColor(Color.WHITE);
         tv.setTextColor(Color.BLUE);
         tv.setPaintColor(Color.RED);
         tv.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
         linearLayout.addView(tv);
		TextView tv1 = (TextView)findViewById(R.id.textview1);
        tv1.setText("android 演示模拟11111");
        tv1.setTextSize(28);
        tv1.setBackgroundColor(Color.WHITE);
        tv1.setTextColor(Color.BLUE);
        tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void linearLayoutExample(View view){
		Intent intent=new Intent(this,LineLayoutActivity.class);  
		startActivity(intent);
	}
	public void openDialog(View view){
		openDialog();
	}
    private void openDialog(){   
        AlertDialog.Builder builder = new AlertDialog.Builder(this);   
        builder.setTitle("Hello");   
        builder.setMessage("Hello World \n");   
        builder.setNegativeButton("OK",null);   
        builder.show();   
    }
    
    public void closeThisActivity(View view){
    	finish();
    }
    
    public void picRead(View view){
		Intent intent=new Intent(this,PicReadActivity.class);  
		startActivity(intent);
    }
    public void openGridView(View view){
		Intent intent=new Intent(this,GridViewActivity.class);  
		startActivity(intent);
    }   
	public void tabLayoutExample(View view){
		Intent intent=new Intent(this,TabLayoutActivity.class);  
		startActivity(intent);
	} 
	public void viewPageExample(View view){
		Intent intent=new Intent(this,ViewPageActivity.class);  
		startActivity(intent);
	} 	
	public void slideTabExample(View view){
		Intent intent=new Intent(this,SlideTabActivity.class);  
		startActivity(intent);
	} 	
}
