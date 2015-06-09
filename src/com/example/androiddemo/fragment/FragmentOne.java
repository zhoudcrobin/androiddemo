package com.example.androiddemo.fragment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.example.androiddemo.R;
import com.example.androiddemo.StreamTool;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class FragmentOne extends ListFragment {
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			try {
				List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
				JSONObject jsonObj = new JSONObject(String.valueOf(msg.obj));
				Log.v("username=====", jsonObj.getString("username"));
				Log.v("password=====", jsonObj.getString("password"));
				Map<String, Object> listItem = new HashMap<String, Object>();
				listItem.put("values", jsonObj.getString("username"));
				listItem.put("images", jsonObj.getString("password"));
				listItems.add(listItem);
				SimpleAdapter adapter = new SimpleAdapter(getActivity(),
						listItems, R.layout.item_list, new String[] { "values",
								"images" }, new int[] { R.id.text_list,
								R.id.button_list });
				setListAdapter(adapter);
			} catch (Exception e) {
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_one, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		new Thread() {
			public void run() {
				try {
					String path = "http://10.0.2.2:8080/smhdemo/common/android/user.do";
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.setConnectTimeout(5000);
					conn.setRequestMethod("GET");
					if (conn.getResponseCode() == 200) {
						InputStream input = conn.getInputStream();
						byte[] data = StreamTool.read(input);
						String stringInfo = new String(data);
						Message msg = new Message();
						msg.obj = stringInfo;
						handler.sendMessage(msg);
						input.close();
					}
					conn.disconnect();
				} catch (Exception e) {
					Log.v("bug", e.toString());
				}
			}
		}.start();
	}
}
