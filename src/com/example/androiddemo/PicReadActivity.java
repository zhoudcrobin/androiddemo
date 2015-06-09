package com.example.androiddemo;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.view.View;

public class PicReadActivity extends ActionBarActivity {
	private final int PICKER = 1;
	
	private int currentPic = 0;
	private Gallery picGallery;
	private ImageView picView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pic_read);
		picView = (ImageView) findViewById(R.id.picture);
		picGallery = (Gallery) findViewById(R.id.gallery);
		PicAdapter imgAdapt = new PicAdapter(this);
		picGallery.setAdapter(imgAdapt);
		picGallery.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView parent, View v, int position, long id) {
			currentPic = position;
			//take the user to their chosen image selection app (gallery or file manager)
			//弹出选择框，询问用户使用图库还是文件管理器选择图片
			Intent pickIntent = new Intent();
			pickIntent.setType("image/*");
			pickIntent.setAction(Intent.ACTION_GET_CONTENT);
			//在onActivityResult事件中获得返回的图片数据
			startActivityForResult(Intent.createChooser(pickIntent, "Select Picture"), PICKER);
			
			return true;	
			}
		});
		picGallery.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView parent, View v, int position, long id) {
			//picView.setImageBitmap(imgAdapt.getPic(position));
		}});

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
		// 检查是否从图片选择器中返回
			if (requestCode == PICKER) {
				Uri pickedUri = data.getData();
				Bitmap pic = null;
				//定义图片路径
				String imgPath = "";
				String[] medData = { MediaStore.Images.Media.DATA };
				//查询数据
				Cursor picCursor = managedQuery(pickedUri, medData, null, null, null);
				if(picCursor!=null)
				{
				//获得图片的路径
				int index = picCursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				picCursor.moveToFirst();
				imgPath = picCursor.getString(index);
				}
				else
				imgPath = pickedUri.getPath();
				if(pickedUri!=null) {
					int targetWidth = 600;
					int targetHeight = 400;
					BitmapFactory.Options bmpOptions = new BitmapFactory.Options();
					bmpOptions.inJustDecodeBounds = true;
					BitmapFactory.decodeFile(imgPath, bmpOptions);
					int currHeight = bmpOptions.outHeight;
					int currWidth = bmpOptions.outWidth;
					int sampleSize = 1;
					if (currHeight>targetHeight || currWidth>targetWidth)
					{
					if (currWidth>currHeight)
					sampleSize = Math.round((float)currHeight/(float)targetHeight);
					else
					sampleSize = Math.round((float)currWidth/(float)targetWidth);
					}
					bmpOptions.inSampleSize = sampleSize;
					bmpOptions.inJustDecodeBounds = false;
					pic = BitmapFactory.decodeFile(imgPath, bmpOptions);
					PicAdapter imgAdapt = new PicAdapter(this);
					imgAdapt.addPic(currentPic,pic);
					picGallery.setAdapter(imgAdapt);
					picView.setImageBitmap(pic);
					picView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				}
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pic_read, menu);
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
