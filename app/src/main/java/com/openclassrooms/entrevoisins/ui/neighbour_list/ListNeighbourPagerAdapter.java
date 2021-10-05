package com.openclassrooms.entrevoisins.ui.neighbour_list;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.openclassrooms.entrevoisins.ui.neighbour_list.favorite.FavoriteNeighbourFragment;
import com.openclassrooms.entrevoisins.ui.neighbour_list.normal.NeighbourFragment;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return NeighbourFragment.newInstance();
            case 1:
                return FavoriteNeighbourFragment.newInstance();
            default:
                return null;
//TODO modif (switch between two instance)
        }
    }
        /**
         * get the number of pages
         *
         * @return
         */
        @Override
        public int getCount () {
            return 2;
        }
    }