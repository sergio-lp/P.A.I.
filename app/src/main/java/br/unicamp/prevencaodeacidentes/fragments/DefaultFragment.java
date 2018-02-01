package br.unicamp.prevencaodeacidentes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.unicamp.prevencaodeacidentes.R;

public class DefaultFragment extends Fragment {
    private TextView tvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_default, container, false);
        tvContent = root.findViewById(R.id.tv_content);
        Bundle b = getArguments();
        Spanned content = (Spanned) b.getCharSequence("content");
        tvContent.setText(content);

        return root;
    }

}
