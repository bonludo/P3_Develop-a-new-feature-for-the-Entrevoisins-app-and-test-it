package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.List;

import static com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator.DUMMY_NEIGHBOURS;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteNeighbourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteNeighbourFragment extends Fragment {

    private NeighbourApiService mApiService;
    private List<Neighbour> mNeighboursFavorite = DUMMY_NEIGHBOURS;
    private OnNeighbourClickedListener onNeighbourClickedListener;


    public FavoriteNeighbourFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static FavoriteNeighbourFragment newInstance() {
        FavoriteNeighbourFragment fragment = new FavoriteNeighbourFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    private void init() {
        mNeighboursFavorite.clear();
        mNeighboursFavorite.addAll(DUMMY_NEIGHBOURS);

        for (int i = 0; i < mNeighboursFavorite.size(); i++) {
            mApiService.getFavorite(mNeighboursFavorite.get(i));




        }
    }
}