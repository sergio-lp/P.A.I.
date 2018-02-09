package br.unicamp.prevencaodeacidentes.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.unicamp.prevencaodeacidentes.R;

public class InfoActivity extends AppCompatActivity {
    private ViewGroup mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ImageButton btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRootLayout = findViewById(R.id.root);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.left_to_right_exit);
    }

    public void onLibrariesClick(View v) {
        View view = getLayoutInflater().inflate(R.layout.view_libraries_dialog, mRootLayout, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Dialog);
        builder.setTitle("Bibliotecas");
        builder.setPositiveButton(R.string.ok, null);
        builder.setView(view);
        builder.show();

        view.findViewById(R.id.url_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.url_fab)));
                startActivity(intent);
            }
        });

        view.findViewById(R.id.url_piv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.url_piv)));
                startActivity(intent);
            }
        });

        view.findViewById(R.id.url_ccb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(R.string.url_ccb)));
                startActivity(intent);
            }
        });

        view.findViewById(R.id.url_microsoft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.microsoft.com"));
                startActivity(i);
            }
        });

        view.findViewById(R.id.url_emojione).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.emojione.com"));
                startActivity(i);
            }
        });

        view.findViewById(R.id.url_twemoji).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://twitter.com"));
                startActivity(i);
            }
        });
    }

    public void onProfisClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://profis.prg.unicamp.br"));
        startActivity(i);
    }

    public void onUnicampLogoClick(View v) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://www.unicamp.br"));
        startActivity(i);
    }

    public void onFeedbackClick(View v) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("message/rfc822");
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"sergio_lpf@outlook.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Feedback - " + getString(R.string.app_name));
        i.putExtra(Intent.EXTRA_TEXT, Html.fromHtml("Android SDK: " + Build.VERSION.SDK_INT) + " - " + Build.VERSION.CODENAME + "\n_________________________________\n\n\n");
        startActivity(i);
    }

    public void onFullArticleClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Dialog);
        builder.setMessage("Ainda indisponível!");
        builder.setTitle("Artigo completo");
        builder.setPositiveButton(R.string.ok, null);
        builder.show();
    }
}
