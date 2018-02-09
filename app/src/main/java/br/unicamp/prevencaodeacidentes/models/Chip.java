package br.unicamp.prevencaodeacidentes.models;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.unicamp.prevencaodeacidentes.R;

public class Chip extends LinearLayout {
    private Context mContext;
    private int mBackgroundSelected;
    private boolean marked;
    private String mText;
    private Drawable mBackground;

    public Chip(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Chip,
                0, 0);

        LayoutInflater.from(context).inflate(R.layout.view_chip, this, true);
        LinearLayout root = findViewById(R.id.ll_chip);
        mBackground = root.getBackground();

        measure(root.getMeasuredWidth(), root.getMeasuredHeight());

        mContext = context;
        TextView textView = findViewById(R.id.tv_chip_text);
        mText = a.getString(R.styleable.Chip_chip_text);
        mBackgroundSelected = a.getColor(R.styleable.Chip_background_selected, 0);
        textView.setText(mText);
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        if (marked) {
            mBackground.setColorFilter(new PorterDuffColorFilter(mBackgroundSelected, PorterDuff.Mode.MULTIPLY));
        } else {
            mBackground.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.chipBackground), PorterDuff.Mode.MULTIPLY));
        }
        this.marked = marked;
    }

    public void setBackgroundSelected(int color) {
        this.mBackgroundSelected = color;
    }

    public void setText(String t) {
        this.mText = t;
    }
}
