package org.iot.ex0727_test02_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      setTitle("탭 레이아웃");

      ViewPager viewPager =  findViewById(R.id.viewpager);
      ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
      viewPager.setAdapter(viewPagerAdapter);

//      TabLayout tab = (TabLayout) findViewById(R.id.tab);
//      tab.setupWithViewPager(viewpager);

   }
}