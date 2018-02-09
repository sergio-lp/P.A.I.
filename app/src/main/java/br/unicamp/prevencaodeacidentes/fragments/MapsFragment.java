package br.unicamp.prevencaodeacidentes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unicamp.prevencaodeacidentes.R;

public class MapsFragment extends Fragment {


    public MapsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_maps, container, false);

        return root;
    }

}
