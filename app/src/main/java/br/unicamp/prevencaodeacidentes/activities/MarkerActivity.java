package br.unicamp.prevencaodeacidentes.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import br.unicamp.prevencaodeacidentes.R;


public class MarkerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_details);

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btnUp = findViewById(R.id.btn_tup_marker);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MarkerActivity.this, "Obrigado! Seu feedback foi registrado.", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton btnDown = findViewById(R.id.btn_tdown_marker);
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MarkerActivity.this, "Obrigado! Seu feedback foi registrado.", Toast.LENGTH_SHORT).show();
            }
        });

        TextView tvTitle = findViewById(R.id.tv_title_marker);
        TextView tvDesc = findViewById(R.id.tv_desc_marker);

        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");

        tvTitle.setText(title);
        tvDesc.setText(desc);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.left_to_right_exit);
    }
}
