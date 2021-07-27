package org.iot.ex0727_test02_fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
   private ArrayList<Fragment> items;
   private ArrayList<String> iText;
   private ArrayList<Integer> img;

   public ViewPagerAdapter(@NonNull FragmentManager fm) {
      super(fm);
      items = new ArrayList<Fragment>();
      iText = new ArrayList<String>();
      img = new ArrayList<Integer>();

      items.add(new Fragment1());
      items.add(new Fragment2());
      items.add(new Fragment3());

      iText.add("첫째");
      iText.add("둘째");
      iText.add("셋째");
   }

   @Nullable
   @Override
   public CharSequence getPageTitle(int position) {
      return iText.get(position);
   }


   @NonNull
   @Override
   public Fragment getItem(int position) {
      return items.get(position);
   }

   @Override
   public int getCount() {
      return items.size();
   }
}
