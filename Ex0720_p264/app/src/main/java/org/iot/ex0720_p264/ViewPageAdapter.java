package org.iot.ex0720_p264;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> items;
    private ArrayList<String> iTexts;

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new Fragment1());
        items.add(new Fragment2());
        items.add(new Fragment3());
        items.add(new Fragment4());

        iTexts = new ArrayList<String>();
        iTexts.add("강아지");
        iTexts.add("고양이");
        iTexts.add("토끼");
        iTexts.add("말");

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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return iTexts.get(position);
    }
}
