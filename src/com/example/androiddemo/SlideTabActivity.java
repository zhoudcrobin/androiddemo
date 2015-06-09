package com.example.androiddemo;

import java.util.ArrayList;
import java.util.List;

import com.example.androiddemo.fragment.FragmentFive;
import com.example.androiddemo.fragment.FragmentFour;
import com.example.androiddemo.fragment.FragmentOne;
import com.example.androiddemo.fragment.FragmentThree;
import com.example.androiddemo.fragment.FragmentTwo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SlideTabActivity extends FragmentActivity implements
		OnCheckedChangeListener {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private List<Fragment> mFragments = new ArrayList<Fragment>();
	private RadioGroup rg;
	private RadioButton rbCurrentRecommend;
	private RadioButton rbView;
	private RadioButton rbFood;
	private RadioButton rbCulture;
	private RadioButton rbEntertainment;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_slide_tab);
		mViewPager = (ViewPager) findViewById(R.id.vp_pager);
		initView();
		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mFragments.size();
			}

			@Override
			public Fragment getItem(int i) {
				// TODO Auto-generated method stub
				return mFragments.get(i);
			}
		};
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				switch (position) {
				case 0:
					rbCurrentRecommend.setChecked(true);
					break;
				case 1:
					rbView.setChecked(true);
					break;
				case 2:
					rbFood.setChecked(true);
					break;
				case 3:
					rbCulture.setChecked(true);
					break;
				case 4:
					rbEntertainment.setChecked(true);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void initView() {
		rg = (RadioGroup) findViewById(R.id.rg_select_main);
		rg.setOnCheckedChangeListener(this);
		rbCurrentRecommend = (RadioButton) findViewById(R.id.rb_current_recommend);
		rbCurrentRecommend.setChecked(true);
		rbView = (RadioButton) findViewById(R.id.rb_view);
		rbFood = (RadioButton) findViewById(R.id.rb_food);
		rbCulture = (RadioButton) findViewById(R.id.rb_culture);
		rbEntertainment = (RadioButton) findViewById(R.id.rb_entertainment);
		FragmentOne fOne = new FragmentOne();
		FragmentTwo fTwo = new FragmentTwo();
		FragmentThree fThree = new FragmentThree();
		FragmentFour fFour = new FragmentFour();
		FragmentFive fFive = new FragmentFive();
		mFragments.add(fOne);
		mFragments.add(fTwo);
		mFragments.add(fThree);
		mFragments.add(fFour);
		mFragments.add(fFive);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rb_current_recommend:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.rb_view:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.rb_food:
			mViewPager.setCurrentItem(2);
			break;
		case R.id.rb_culture:
			mViewPager.setCurrentItem(3);
			break;
		case R.id.rb_entertainment:
			mViewPager.setCurrentItem(4);
			break;
		}
	}
}