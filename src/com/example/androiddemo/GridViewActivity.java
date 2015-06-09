package com.example.androiddemo;

import java.util.ArrayList;
import java.util.HashMap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.view.View;

public class GridViewActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);
		GridView gridview = (GridView) findViewById(R.id.GridView);
		ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();
		for (int i = 1; i < 16; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.ic_launcher);
			map.put("ItemText", "" + i);
			meumList.add(map);
		}
		SimpleAdapter saItem = new SimpleAdapter(this, meumList, // ����Դ
				R.layout.item, // xmlʵ��
				new String[] { "ItemImage", "ItemText" }, // ��Ӧmap��Key
				new int[] { R.id.ItemImage, R.id.ItemText }); // ��ӦR��Id

		// ���Item��������
		gridview.setAdapter(saItem);
		// ��ӵ���¼�
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = arg2 + 1;// id�Ǵ�0��ʼ�ģ�������Ҫ+1
				Toast.makeText(getApplicationContext(), "�㰴����ѡ�" + index, 0)
						.show();
				// Toast�������û���ʾһЩ����/��ʾ
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_view, menu);
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
