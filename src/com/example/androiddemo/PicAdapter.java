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
	//Ĭ�ϵı�������
	int defaultItemBackground;
	//galleryͼ��������ı���
	private Context galleryContext;
	//��ʾͼƬ������
	private Bitmap[] imageBitmaps;
	//��ͼ���е�һ���հ׵�ռλ��
	Bitmap placeholder;
	
	public PicAdapter(Context c) {
		//ʵ����context������
		galleryContext = c;
		//����bitmap����
		imageBitmaps = new Bitmap[10];
		//����placeholder��ͼƬ
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
		//����imageview
		ImageView imageView = new ImageView(galleryContext);
		//ָ��Ҫ��ʾ��һ���û�ѡ����ͼ�Ĵ�ͼ
		imageView.setImageBitmap(imageBitmaps[position]);
		//����ͼƬ�����Դ�С
		imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
		//������ʾ����ı���
		imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		//����ͼƬ�ı���ɫ
		imageView.setBackgroundResource(defaultItemBackground);
		//������ͼ
		return imageView;
	}
	
	public void addPic(int currentPic,Bitmap newPic){
		imageBitmaps[currentPic] = newPic;
	}
	public Bitmap getPic(int posn){
		return imageBitmaps[posn];
	}
}

