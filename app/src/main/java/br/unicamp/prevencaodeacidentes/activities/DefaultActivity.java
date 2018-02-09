package br.unicamp.prevencaodeacidentes.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.unicamp.prevencaodeacidentes.R;
import br.unicamp.prevencaodeacidentes.fragments.DefaultFragment;
import br.unicamp.prevencaodeacidentes.fragments.QuizFragment;
import br.unicamp.prevencaodeacidentes.models.Chip;
import br.unicamp.prevencaodeacidentes.models.Warning;

public class DefaultActivity extends AppCompatActivity {
    private ViewPager mPager;
    private android.support.design.widget.FloatingActionButton mFAB;
    private int mCurrentItem = 0;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        mProgressBar = findViewById(R.id.map_progress_bar);
        TextView tvTitle = findViewById(R.id.tv_title_default);
        String title = getIntent().getExtras().getString("title");
        tvTitle.setText(title);

        final List<Fragment> fragmentList = new ArrayList<>();

        DefaultFragment fragment1 = new DefaultFragment();
        Bundle b = new Bundle();
        Spanned content = SpannableString.valueOf("Ainda indisponível");

        switch (title) {
            case "Queimaduras":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Não deixe fósforos, isqueiros, e outras fontes de energia ao alcance dos pequenos." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Mantenha a criança longe da cozinha e do fogão, principalmente durante o preparo das refeições." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Cozinhe nas bocas de trás do fogão e sempre deixe os cabos das panelas virados para trás." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Evite carregar crianças no colo enquanto mexe em panelas no fogão ou manipula líquidos quentes." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não deixe as crianças por perto quando estiver passando roupa, nem largue o ferro elétrico sem vigilância.");
                break;
            case "Choques":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Empinar pipa só em lugares abertos, longe de fios elétricos." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> As tomadas devem estar protegidas por tampas apropriadas, esparadrapo, fita isolante, ou mesmo coberta por móveis");
                break;
            case "Intoxicações":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Conheça as plantas de sua casa e remova as venenosas." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Certifique-se de que os brinquedos da criança são atóxicos e indicados à idade dela. Compre produtos com selo do Inmetro." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Saiba quais produtos domésticos são tóxicos. Produtos comuns, como enxaguantes bucais, podem ser nocivos se a criança engolir em grande quantidade." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Mantenha medicamentos trancados e nunca se refira a eles como 'doce'. Isto pode levar a criança a pensar que não é perigoso ou que é agradávl de comer." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Guarde todos os produtos de higiene e limpeza trancados, fora da vista e do alcance das crianças. A cor dos produtos e de suas embalagens pode chamar a antenção." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Se a criança tomar medicamentos ou produtos tóxicos, faça contato imediato com seu médico ou serviço de urgência.");
                break;
            case "Asfixia":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Corte os alimentos em pedaços bem pequenos na hora de alimentar a criança." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Deixe o chão livre de objetos pequenos como botões, bolas de gude, moedas e tachinhas, para não correr o risco da criança engolir." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Certifique-se de que os brinquedos da criança não possuem partes pequenas e que se soltam." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não deixe a criança sozinha no carro, mesmo que o vidro esteja entreaberto." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Brinquedos com correntes, tiras e cordas com mais de 15 cm devem ser evitados." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Nunca deixe sacos plásticos ao alcance das crianças.");
                break;
            case "Afogamento":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> As crianças devem sempre ser supervisionadas por um adulto quando estiverem próximas de água." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Instale cercas de isolamento na piscina com, no mínimo, 1,5m de altura, cadeados e travas." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Evite brinquedos e outros atrativos próximos a piscinas e reservatórios de água." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Boias e outros equipamentos infláveis passam uma falsa sensação de segurança. O ideal é que a criança use sempre um colete salva-vidas em embarcações ou na prática de esportes aquáticos." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Ensine a criança a não brincar de empurrar e a não simular que está se afogando." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Conserve a tampa do vaso sanitário fechada ou lacrada com dispositivo de segurança ou mantenha a porta do banheiro trancada." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Nunca deixa a criança sozinha na banheira." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Mantenha cisternas, tonéis, poços e outros reservatórios domésticos trancados ou com proteção." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Deixe os baldes com água no alto, longe do alcance das crianças, esvazie todos após o uso e guarde-os virados para baixo.");
                break;
            case "Transporte":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Crianças com menos de 10 anos devem sentar no banco de trás do carro. Até os 7 anos, é importante usar cadeirinhas de segurança adequadas à idade e ao peso da criança. Sempre usar cinto de segurança." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Ao contratar transporte escolar, busque referências e verifique a documentação do veículo e do motorista.");
                break;
            case "Traumas e precauções gerais":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Mantenha camas, armários e outros móveis longe das janelas e cortinas e verifique se estão estáveis." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Cuidado com a quina dos móveis." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não use toalhas de mesa compridas." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Cuidado com pisos escorregadios, coloque antiderrapante nos tapetes.");
                break;
            case "Quedas":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Escadas, sacadas e lajes não são lugares para brincar." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> No parquinho, verifique se os equipamentos são apropriados à idade da criança e fique atento a perigos como ferrugem, pregos expostos e superfícies instáveis." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> O piso dos parquinhos deve absorver o impacto, sendo de grama, emborrachado ou areia." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Ensine regras de comportamento, como não empurrar, nem se amontoar." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Ensine a criança a usar capacete quando estiver de bicicleta, skate ou patins." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Crianças com menos de 6 anos não devem dormir em beliches. Se não houver escolha, coloque grades de proteção nas laterais." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Nunca deixe um bebê sozinho em mesas, camas ou outros móveis, mesmo que seja por pouco tempo." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> As grades de proteção do berço devem estar fixas. O vão entre as grades não deve ter mais que 6 cm de distância." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Remova do berço todos os brinquedos, travesseiros e objetos macios quando o bebê estiver dormindo." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Instale grades ou redes de proteção nas janelas, sacadas e mezaninos. As redes devem ter espaços de no máximo 6 cm." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Use portões de segurança no topo e na base das escadas e, caso sejam abertas, instale redes de proteção.");
                break;
            case "Atropelamento":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Ensine a criança a respeitar os sinais de trânsito, atravessar a rua na faixa de pedestres e olhando para os dois lados." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Menores de 10 anos não devem atravessar a rua sozinhos. É importante segurar os pequenos pelo pulso." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Entradas de garagens, quintais sem cerca ou estacionamentos não são seguros para brincadeiras.");
                break;
            case "Alimentação":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> A carne de porco era proíbida para crianças a partir de 6 meses de idade por ser\n" +
                        "gordurosa e pobre em nutrientes. Acreditava-se, portanto, que faria mal à digestão\n" +
                        "do bebê. Entretanto, estudos recentes ressaltam que o lombo suíno chega a ter\n" +
                        "40% menos gordura que a carne de vaca, além de ser rica em vitamina B1 e ideal\n" +
                        "para prevenção de doenças cardíacas e neurológicas." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> O ovo só podia ser consumido por bebês com mais de nove meses por causa da\n" +
                        "albumina presente na clara, um composto alergênico, apenas a gema era\n" +
                        "permitida. Porém, estudos mostram que o ovo inteiro pode ser ingerido. Só é\n" +
                        "vetado para bebês com histórico familiar de alergia ou que apresentem algum tipo\n" +
                        "de reação durante a amamentação." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Recomendava-se bananas de dois tipos: a prata e a nanica, consideradas mais\n" +
                        "leves e de fácil absorção. Todavia, todos os tipos (ouro, nanica, da-terra, prata,\n" +
                        "maçã ou banana-d’água) têm as mesmas propriedades e papel semelhante no\n" +
                        "processo de digestão." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> O amendoim era vetado por conter pelo menos nove tipos de proteína com alto\n" +
                        "poder alergênico. Poderia causar intoxicação no bebê. No entanto o contato\n" +
                        "precoce com o alimento na forma de pasta estimula o sistema imunológico a\n" +
                        "assimilar as proteínas e assim evitar reação alérgica.");
                break;
            case "Animais peçonhentos":
                content = Html.fromHtml("<font color='#ff1744'><b>•</b></font> Não permitir que crianças brinquem em terrenos baldios." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não deixar entulhos no quintal." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não manter ambientes favoráveis à proliferação desses animais, como tijolos\n" +
                        "empilhados, caixas de papelão, madeiras etc." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Olhar o calçado antes de colocá-los." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Não andar descalço em ambientes desconhecidos.");
                break;
            case "Higiene":
                content = Html.fromHtml("<font color='#ff1744'><b><h2>O que a criança deve aprender sobre higiene pessoal:</h2></b></font>" +
                        "<font color='#ff1744'><b>•</font> Escovar os dentes:</b> Os pais devem explicar a maneira correta de fazê-lo, como\n" +
                        "escovar a língua e de que forma usa-se o fio dental. Atenção: nos primeiros dias,\n" +
                        "fique olhando para ver se seu filho faz certo; depois o deixe fazer sozinho, mas\n" +
                        "fiscalize, veja se está bem feito. Depois de um tempo, quando vir que ele\n" +
                        "desempenha bem essa função, pode deixá-lo fazer totalmente sozinho." +
                        "<br /><br /><font color='#ff1744'><b>•</font> Lavar as mãos: </b>antes das refeições, depois de usar o banheiro e quando chegar da\n" +
                        "rua. Até os quatro anos, os pais devem levar a criança para lavar as mãos. Depois\n" +
                        "dessa idade, podem apenas reforçar o recado, mas deixando que o façam.\n" +
                        "Lembre-se de ensinar cada passo – água, sabão, enxáguar e enxugar." +
                        "<br /><br /><font color='#ff1744'><b>•</font> Pentear os cabelos: </b>para os meninos, essa tarefa é mais fácil; as meninas\n" +
                        "precisam de mais atenção, até pelo, menos sete ou oito anos de idade para lavá-\n" +
                        "los e penteá-los. O importante é ensinar desde cedo a pentear o cabelo ao acordar\n" +
                        "e depois do banho." +
                        "<br /><br /><font color='#ff1744'><b>•</font> Tomar banho: </b>É preciso que a criança tenham uma hora marcada para tomar o\n" +
                        "banho e seus utensílios (sabonetes, xampu, condicionador e toalhas) devem estar\n" +
                        "sempre ao seu alcance quando estão aprendendo a tomar banho sozinhas. Os pais\n" +
                        "devem mostrar a maneira certa de lavar as partes íntimas, os pés e todo o corpo.\n" +
                        "\n" +
                        "Elas precisam de auxílio até uns seis anos, quando podem exercer essa atividade\n" +
                        "totalmente sozinhas.");
                break;
            case "Telefones":
                content = Html.fromHtml("<h2><font color='#ff3b3e'>Em todo o Brasil:</font></h2>" +
                        "Serviço de atendimento móvel de urgência (SAMU): <b><font color='#ff3b3e'>192</font></b>" +
                        "<br />Polícia Militar (PM): <b><font color='#ff3b3e'>190</font></b>" +
                        "<br />Corpo de Bombeiros: <b><font color='#ff3b3e'>193</font></b>" +
                        "<br /><br /><h2><font color='#ff3b3e'>Em Campinas - SP:</font></h2>" +
                        "CIATox UNICAMP: <b><font color='#ff3b3e'>(19) 3521-7555</b></font>");
                break;
        }
        b.putCharSequence("content", content);
        fragment1.setArguments(b);

        mFAB = findViewById(R.id.fab_default);
        mFAB.setVisibility(View.INVISIBLE);

        fragmentList.add(fragment1);

        if (!title.equals("Telefones") && !title.equals("Mapa")) {
            final QuizFragment fragment3 = new QuizFragment();
            fragmentList.add(fragment3);
            mFAB.setVisibility(View.VISIBLE);
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

        if (title.equals("Mapa")) {
            fragmentList.clear();
            SupportMapFragment mapFragment = new SupportMapFragment();
            fragmentList.add(mapFragment);
            prepareMapFragment(mapFragment);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mPager = findViewById(R.id.pager);
        PagerAdapter mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

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
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_to_right, R.anim.left_to_right_exit);
    }

    private void prepareMapFragment(SupportMapFragment mapFragment) {
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final GoogleMap googleMap) {
                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        Intent i = new Intent(DefaultActivity.this, MarkerActivity.class);
                        i.putExtra("title", marker.getTitle());
                        i.putExtra("desc", marker.getSnippet());
                        startActivity(i);
                    }
                });

                final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

                ValueEventListener eventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot s : dataSnapshot.child("risksCoords").getChildren()) {
                            Warning w = s.getValue(Warning.class);

                            if (w != null) {
                                googleMap.addMarker(new MarkerOptions().snippet(w.getDescription())
                                        .title(w.getTitle()).icon(BitmapDescriptorFactory.defaultMarker(w.getType()))
                                        .position(new LatLng(w.getLat(), w.getLon())));
                            }
                        }

                        mProgressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(DefaultActivity.this, "Desculpe! Ocorreu um erro.", Toast.LENGTH_SHORT).show();
                    }
                };

                database.addValueEventListener(eventListener);

                LatLng campinas = new LatLng(-22.907104f, -47.063240);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(campinas, 10));

                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(final LatLng latLng) {
                        AlertDialog.Builder newMarkDialog = prepareMarkDialog(
                                database,
                                latLng
                        );

                        newMarkDialog.show();
                    }
                });

                if (ActivityCompat.checkSelfPermission(DefaultActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(DefaultActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                googleMap.setMyLocationEnabled(true);
            }
        });
    }

    private AlertDialog.Builder prepareMarkDialog(final DatabaseReference marks,
                                                  final LatLng latLng) {

        AlertDialog.Builder markDialog = new AlertDialog.Builder(DefaultActivity.this);
        View dialog = LayoutInflater.from(DefaultActivity.this)
                .inflate(R.layout.view_new_mark_dialog, mPager, false);
        markDialog.setView(dialog);

        final EditText edTitle = dialog.findViewById(R.id.ed_title);
        final EditText edDescription = dialog.findViewById(R.id.ed_description);

        final List<Chip> chipList = new ArrayList<>();

        chipList.add((Chip) dialog.findViewById(R.id.chip_fall));
        chipList.add((Chip) dialog.findViewById(R.id.chip_animals));
        chipList.add((Chip) dialog.findViewById(R.id.chip_assault));
        chipList.add((Chip) dialog.findViewById(R.id.chip_electricity));
        chipList.add((Chip) dialog.findViewById(R.id.chip_vegetation));

        View.OnClickListener chipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Chip c : chipList) {
                    if (c.getId() == v.getId()) {
                        c.setMarked(!c.isMarked());
                    } else {
                        c.setMarked(false);
                    }
                }
            }
        };

        for (Chip c : chipList) {
            c.setOnClickListener(chipClick);
        }

        final List<Integer> lastID = new ArrayList<>();

        markDialog.setTitle("Nova área de risco");
        markDialog.setNegativeButton("Cancelar", null);
        markDialog.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Query lastQuery = marks.child("risksCoords").orderByKey().limitToLast(1);
                lastQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        lastID.clear();
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            lastID.add(Integer.valueOf(child.getKey()) + 1);
                        }

                        Chip checkedChip = null;
                        for (Chip c : chipList) {
                            if (c.isMarked()) {
                                checkedChip = c;
                            }
                        }

                        if (checkedChip == null) {
                            Toast.makeText(DefaultActivity.this, "Selecione um tipo de risco!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        float color = 0;
                        switch (checkedChip.getId()) {
                            case R.id.chip_fall:
                                color = BitmapDescriptorFactory.HUE_RED;
                                break;
                            case R.id.chip_animals:
                                color = BitmapDescriptorFactory.HUE_BLUE;
                                break;
                            case R.id.chip_vegetation:
                                color = BitmapDescriptorFactory.HUE_GREEN;
                                break;
                            case R.id.chip_electricity:
                                color = BitmapDescriptorFactory.HUE_ORANGE;
                                break;
                            case R.id.chip_assault:
                                color = BitmapDescriptorFactory.HUE_MAGENTA;
                                break;
                        }

                        int id;
                        if (lastID.size() == 1) {
                            id = lastID.get(0);
                        } else {
                            id = 0;
                        }

                        Warning w = new Warning(edTitle.getText().toString(),
                                edDescription.getText().toString(),
                                color,
                                latLng.latitude,
                                latLng.longitude);

                        marks.child("risksCoords").child(Integer.toString(id)).setValue(w);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(DefaultActivity.this, "Desculpe! Ocorreu um erro.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return markDialog;
    }
}
