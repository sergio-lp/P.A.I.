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

        CustomButton btnFire = findViewById(R.id.btn1);
        CustomButton btnVoltage = findViewById(R.id.btn2);
        CustomButton btnToxic = findViewById(R.id.btn3);
        CustomButton btnChoke = findViewById(R.id.btn4);
        CustomButton btnPhones = findViewById(R.id.btn5);
        CustomButton btnDrown = findViewById(R.id.btn6);
        CustomButton btnTransport = findViewById(R.id.btn7);
        CustomButton btnGeneral = findViewById(R.id.btn8);
        CustomButton btnFall = findViewById(R.id.btn9);
        CustomButton btnRunOver = findViewById(R.id.btn10);
        CustomButton btnFood = findViewById(R.id.btn11);
        CustomButton btnHygiene = findViewById(R.id.btn12);
        CustomButton btnAnimals = findViewById(R.id.btn13);
        CustomButton btnInfo = findViewById(R.id.btn_info);

        btnFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Queimaduras");
                startActivity(i);
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

        btnToxic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Intoxicações");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnChoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Asfixia");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnDrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Afogamento");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Transporte");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Traumas e precauções gerais");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnRunOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Atropelamento");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Quedas");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Alimentação");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnHygiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Higiene");
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                i.putExtra("title", "Animais peçonhentos");
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
