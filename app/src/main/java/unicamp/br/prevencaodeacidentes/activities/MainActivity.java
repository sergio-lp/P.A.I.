package unicamp.br.prevencaodeacidentes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import unicamp.br.prevencaodeacidentes.R;
import unicamp.br.prevencaodeacidentes.models.CustomButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomButton btnPhones = findViewById(R.id.btn5);
        CustomButton btnInfo = findViewById(R.id.btn6);

        btnPhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), PhonesActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), InfoActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }

}
