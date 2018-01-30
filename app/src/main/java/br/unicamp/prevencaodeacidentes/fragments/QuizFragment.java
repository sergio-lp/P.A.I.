package br.unicamp.prevencaodeacidentes.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.unicamp.prevencaodeacidentes.R;
import br.unicamp.prevencaodeacidentes.models.CustomRadioGroup;

public class QuizFragment extends Fragment {
    private CustomRadioGroup mQuestion1;
    private CustomRadioGroup mQuestion2;
    private CustomRadioGroup mQuestion3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        mQuestion1 = root.findViewById(R.id.question_1);
        mQuestion2 = root.findViewById(R.id.question_2);
        mQuestion3 = root.findViewById(R.id.question_3);

        return root;
    }

    public long checkAnswers() {
        if (mQuestion1.getSelected() != null && mQuestion2.getSelected() != null
                && mQuestion3.getSelected() != null) {
            mQuestion1.giveAnswer();
            mQuestion2.giveAnswer();
            mQuestion3.giveAnswer();

            return 0;
        }

        Toast.makeText(getContext(), "Responda todas as perguntas!", Toast.LENGTH_SHORT).show();
        return -1;
    }

}
