package com.openclassrooms.entrevoisins.ui.neighbour_list.favorite;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourRepository;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteNeighbourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteNeighbourFragment extends Fragment {

    private NeighbourRepository mNeighbourRepository;
    private List<Neighbour> mNeighboursFavorite;

    // TODO: Rename and change types and number of parameters
    public static FavoriteNeighbourFragment newInstance() {
        return new FavoriteNeighbourFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNeighboursFavorite = mNeighbourRepository.getFavorites();
    }
}