package br.unicamp.prevencaodeacidentes.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.unicamp.prevencaodeacidentes.R;

public class CustomButton extends LinearLayout {
    private String mText;
    private int mDrawable;
    private ImageView mImageLeft;
    private ImageView mImageRight;
    private TextView mTextView;

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomButton,
                0, 0
        );

        mText = a.getString(R.styleable.CustomButton_txt);
        mDrawable = a.getResourceId(R.styleable.CustomButton_image, 0);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_button, this, true);

        measure(findViewById(R.id.btn_relative).getMeasuredWidth(), findViewById(R.id.btn_relative).getMeasuredHeight());

        mTextView = this.findViewById(R.id.btn_text);
        mImageLeft = this.findViewById(R.id.btn_img_left);
        mImageRight = this.findViewById(R.id.btn_img_right);


        mTextView.setText(mText);
        mImageRight.setImageDrawable(getResources().getDrawable(mDrawable));
        mImageLeft.setImageDrawable(getResources().getDrawable(mDrawable));

    }
}
