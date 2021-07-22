package org.iot.ex0720_tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("탭 구현");

        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);

        ArrayList<Integer> img = new ArrayList<>();
        img.add(R.drawable.android);
        img.add(R.drawable.android);
        img.add(R.drawable.android);

        for (int i =0; i<img.size(); i++){
            tab.getTabAt(i).setIcon(img.get(i));
        }
    }
}