package br.unicamp.prevencaodeacidentes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.unicamp.prevencaodeacidentes.R;
import br.unicamp.prevencaodeacidentes.models.CustomButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomButton btnPhones = findViewById(R.id.btn5);
        CustomButton btnInfo = findViewById(R.id.btn6);

        CustomButton btnFire = findViewById(R.id.btn1);
        CustomButton btnVoltage = findViewById(R.id.btn2);

        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Test activity layout
                startActivity(new Intent(MainActivity.this, AltMainActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnVoltage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Choques");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Telefones");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }

}
