package com.dima.testing_big_dig.View.PagerAdapter;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dima.testing_big_dig.View.fragments.History_fragment.History;
import com.dima.testing_big_dig.View.fragments.Text_fragment.Test;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new Test();
        }
        else if (position == 1)
        {
            fragment = new History();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Test";
        }
        else if (position == 1)
        {
            title = "History";
        }
        return title;
    }
}