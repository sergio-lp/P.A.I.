package br.unicamp.prevencaodeacidentes.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.unicamp.prevencaodeacidentes.R;

public class CustomButtonCircle extends LinearLayout {

    public CustomButtonCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomButtonCircle,
                0, 0
        );

        String name = a.getString(R.styleable.CustomButtonCircle_txt_circle);
        int drawable = a.getResourceId(R.styleable.CustomButtonCircle_image_circle, 0);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.button_circle, this, true);

        measure(findViewById(R.id.btn_relative).getMeasuredWidth(), findViewById(R.id.btn_relative).getMeasuredHeight());

        TextView tvName = this.findViewById(R.id.btn_text);
        ImageView imgIcon = this.findViewById(R.id.btn_img_center);

        Log.d("Drawable", "CustomButtonCircle: " + Integer.toString(drawable));

        imgIcon.setImageDrawable(getResources().getDrawable(drawable));
        tvName.setText(name);
    }

}
