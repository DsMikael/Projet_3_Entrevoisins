package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> lstFragment = new ArrayList<>();

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
//        NeighbourFragment.newInstance();
        return lstFragment.get(position);
    }

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
       return lstFragment.size();
    }


    public void AddFragment (Fragment fragment){
        lstFragment.add(fragment);
    }
}