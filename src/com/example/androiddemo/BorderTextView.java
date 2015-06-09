package com.example.androiddemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 *  
 * @author zhoudongchu
 */
public class BorderTextView extends TextView {
	public BorderTextView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	private Paint paint = null;
	private int color = Color.GRAY;

	   //���ñ߿���ɫ
		public void setPaintColor(int color){
			this.color = color;
		}
		@Override
		protected void onDraw(Canvas canvas)
		{
			super.onDraw(canvas);
			paint = new Paint();
			//���߿�������ɫ
			paint.setColor(color);
			//��
			canvas.drawLine(0, 0, this.getWidth()-1, 0, paint);
			//��
			canvas.drawLine(0, 0, 0, this.getHeight()-1, paint);
			//��
			canvas.drawLine(0, this.getHeight()-1, this.getWidth()-1, this.getHeight()-1, paint);
			//��
			canvas.drawLine(this.getWidth()-1, 0, this.getWidth()-1, this.getHeight()-1, paint);
		}

}

