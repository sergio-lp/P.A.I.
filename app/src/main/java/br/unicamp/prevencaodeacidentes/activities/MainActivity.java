package br.unicamp.prevencaodeacidentes.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

import br.unicamp.prevencaodeacidentes.R;
import br.unicamp.prevencaodeacidentes.models.CustomButton;

public class MainActivity extends AppCompatActivity {
    private static final String SHOW_DIALOG = "show_dialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareButtons();

        final SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        CustomButton btnMap = findViewById(R.id.btn_map);

        if (!sharedPref.getBoolean(SHOW_DIALOG, true)) {
            btnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    askLocationPermission();
                }
            });
        } else {
            btnMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder mapDialog = new AlertDialog.Builder(MainActivity.this);
                    mapDialog.setCancelable(true);
                    mapDialog.setTitle("Mapa de Risco");
                    mapDialog.setNegativeButton("Voltar", null);
                    final View dialog = LayoutInflater.from(MainActivity.this)
                            .inflate(R.layout.view_map_dialog,
                                    ((ScrollView) MainActivity.this.findViewById(R.id.root)),
                                    false);
                    mapDialog.setView(dialog);
                    mapDialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
                    mapDialog.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface d, int which) {
                            CheckBox box = dialog.findViewById(R.id.cb_map_dialog);
                            if (box.isChecked()) {
                                sharedPref.edit().putBoolean(SHOW_DIALOG, false).apply();
                            }

                            askLocationPermission();

                        }
                    });
                    if (sharedPref.getBoolean(SHOW_DIALOG, true)) {
                        mapDialog.show();
                    } else {
                        askLocationPermission();
                    }
                }
            });
        }
    }

    private void prepareButtons() {
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

    private void askLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
        } else {
            Intent i = new Intent(MainActivity.this, DefaultActivity.class);
            i.putExtra("title", "Mapa");
            startActivity(i);
            overridePendingTransition(R.anim.enter, R.anim.exit);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                    i.putExtra("title", "Mapa");
                    startActivity(i);
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                } else {
                    Toast.makeText(this,
                            "Algumas funções ficam indisponíveis sem acesso a localização",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, DefaultActivity.class);
                    i.putExtra("title", "Mapa");
                    startActivity(i);
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                }
        }
    }
}
