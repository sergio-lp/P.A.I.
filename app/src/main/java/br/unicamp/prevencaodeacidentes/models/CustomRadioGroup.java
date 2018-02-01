package br.unicamp.prevencaodeacidentes.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.igenius.customcheckbox.CustomCheckBox;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.prevencaodeacidentes.R;

public class CustomRadioGroup extends LinearLayout {
    private int mCorrect;
    private RadioGroup mRadioGroup;
    private CustomCheckBox mCheckBox1;
    private CustomCheckBox mCheckBox2;
    private CustomCheckBox mCheckBox3;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;

    public CustomRadioGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_radiogroup, this, true);

        measure(findViewById(R.id.radiogroup_custom).getMeasuredWidth(), findViewById(R.id.radiogroup_custom).getMeasuredHeight());

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomRadioGroup,
                0, 0);

        mCheckBox1 = findViewById(R.id.checkbox_1);
        mCheckBox2 = findViewById(R.id.checkbox_2);
        mCheckBox3 = findViewById(R.id.checkbox_3);

        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                mRadioGroup.check(view.getId());
            }
        };

        mCheckBox1.setOnClickListener(listener);
        mCheckBox2.setOnClickListener(listener);
        mCheckBox3.setOnClickListener(listener);

        LinearLayout llContainer1 = findViewById(R.id.ll_container_1);
        LinearLayout llContainer2 = findViewById(R.id.ll_container_2);
        LinearLayout llContainer3 = findViewById(R.id.ll_container_3);

        llContainer1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox1.isClickable()) {
                    mRadioGroup.check(mCheckBox1.getId());
                }
            }
        });

        llContainer2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox2.isClickable()) {
                    mRadioGroup.check(mCheckBox2.getId());
                }
            }
        });

        llContainer3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox3.isClickable()) {
                    mRadioGroup.check(mCheckBox3.getId());
                }
            }
        });

        final List<CustomCheckBox> customCheckBoxList = new ArrayList<>();
        customCheckBoxList.add(mCheckBox1);
        customCheckBoxList.add(mCheckBox2);
        customCheckBoxList.add(mCheckBox3);

        mRadioGroup = findViewById(R.id.radiogroup_custom);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                CustomCheckBox clicked = mRadioGroup.findViewById(i);
                for (i = 0; i < customCheckBoxList.size(); i++) {
                    customCheckBoxList.get(i).setChecked(false, false);
                }
                clicked.setChecked(true, !clicked.isChecked());
            }
        });

        String answer1 = a.getString(R.styleable.CustomRadioGroup_answer_1);
        String answer2 = a.getString(R.styleable.CustomRadioGroup_answer_2);
        String answer3 = a.getString(R.styleable.CustomRadioGroup_answer_3);
        mCorrect = a.getResourceId(R.styleable.CustomRadioGroup_correct, 0);

        mTextView1 = findViewById(R.id.tv_answer_1);
        mTextView2 = findViewById(R.id.tv_answer_2);
        mTextView3 = findViewById(R.id.tv_answer_3);

        mTextView1.setText(answer1);
        mTextView2.setText(answer2);
        mTextView3.setText(answer3);
    }

    public TextView getCorrect() {
        if (mCorrect == mCheckBox1.getId()) {
            return mTextView1;
        } else if (mCorrect == mCheckBox2.getId()) {
            return mTextView2;
        } else if (mCorrect == mCheckBox3.getId()) {
            return mTextView3;
        }

        return null;
    }

    public TextView getSelected() {
        if (mCheckBox1.isChecked()) {
            return mTextView1;
        } else if (mCheckBox2.isChecked()) {
            return mTextView2;
        } else if (mCheckBox3.isChecked()) {
            return mTextView3;
        }

        return null;
    }

    public void giveAnswer() {
        boolean isCorrect = mRadioGroup.getCheckedRadioButtonId() == mCorrect;

        if (getSelected() != null) {
            getCorrect().setTextColor(getResources().getColor(R.color.green_accent));
            if (!isCorrect) {
                getSelected().setTextColor(getResources().getColor(R.color.red_accent));
            }

            mCheckBox1.setClickable(false);
            mCheckBox2.setClickable(false);
            mCheckBox3.setClickable(false);
            mCheckBox1.setVisibility(INVISIBLE);
            mCheckBox2.setVisibility(INVISIBLE);
            mCheckBox3.setVisibility(INVISIBLE);
        } else {
            Toast.makeText(getContext(), "Responda todas as perguntas!", Toast.LENGTH_SHORT).show();
        }
    }
}
