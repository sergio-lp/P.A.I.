package br.unicamp.prevencaodeacidentes.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.prevencaodeacidentes.R;
import br.unicamp.prevencaodeacidentes.fragments.DefaultFragment;
import br.unicamp.prevencaodeacidentes.fragments.QuizFragment;

public class DefaultActivity extends AppCompatActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private FloatingActionButton mFAB;
    private int mCurrentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        TextView tvTitle = findViewById(R.id.tv_title_default);
        tvTitle.setText(getIntent().getExtras().getString("title"));

        final List<Fragment> fragmentList = new ArrayList<>();
        DefaultFragment fragment1 = new DefaultFragment();
        DefaultFragment fragment2 = new DefaultFragment();
        final QuizFragment fragment3 = new QuizFragment();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mFAB = findViewById(R.id.fab_deafault);

        mPager = findViewById(R.id.pager);
        mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentItem = position;
                Drawable check = getResources().getDrawable(R.drawable.ic_check_white_24dp);
                Drawable next = getResources().getDrawable(R.drawable.ic_arrow_right_white_24dp);

                if (position == fragmentList.size() - 1) {
                    mFAB.setImageDrawable(check);
                } else {
                    if (mFAB.getDrawable() != next) {
                        mFAB.setImageDrawable(next);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mPager.setAdapter(mPagerAdapter);
        mCurrentItem = mPager.getCurrentItem();
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentItem == fragmentList.size() - 1) {
                    long r = fragment3.checkAnswers();
                    if (r == 0) {
                        mFAB.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });
                    }
                } else {
                    mCurrentItem++;
                    mPager.setCurrentItem(mCurrentItem);
                }
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.left_to_right_exit);
    }
}
