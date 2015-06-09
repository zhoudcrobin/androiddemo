package com.example.androiddemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * 
 *  
 * @author zhoudongchu
 */
public class PicAdapter extends BaseAdapter {
	//默认的背景参数
	int defaultItemBackground;
	//gallery图库的上下文变量
	private Context galleryContext;
	//显示图片的数组
	private Bitmap[] imageBitmaps;
	//在图库中的一个空白的占位符
	Bitmap placeholder;
	
	public PicAdapter(Context c) {
		//实例化context上下文
		galleryContext = c;
		//创建bitmap数组
		imageBitmaps = new Bitmap[10];
		//设置placeholder的图片
		placeholder = BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_launcher);
		for(int i=0; i<10;i++){
			imageBitmaps[i]=placeholder;
			TypedArray styleAttrs = galleryContext.obtainStyledAttributes(R.styleable.PicGallery);
			defaultItemBackground = styleAttrs.getResourceId(R.styleable.PicGallery_android_galleryItemBackground, 0);
			styleAttrs.recycle();
		}

	}

	@Override
	public int getCount() {
		return imageBitmaps.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//创建imageview
		ImageView imageView = new ImageView(galleryContext);
		//指定要显示哪一张用户选定的图的大图
		imageView.setImageBitmap(imageBitmaps[position]);
		//设置图片的属性大小
		imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
		//设置显示区域的比例
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		//设置图片的背景色
		imageView.setBackgroundResource(defaultItemBackground);
		//返回视图
		return imageView;
	}
	
	public void addPic(int currentPic,Bitmap newPic){
		imageBitmaps[currentPic] = newPic;
	}
	public Bitmap getPic(int posn){
		return imageBitmaps[posn];
	}
}

