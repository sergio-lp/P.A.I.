package br.unicamp.prevencaodeacidentes.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
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
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Brinquedos com correntes, tiras e cordas com mais de 15cm devem ser evitados.");
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
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Cuidado com pisos escorregadios, coloque antiderrapante nos tapetes." +
                        "<br /><br /><font color='#ff1744'><b>•</b></font> Nunca deixe sacos plásticos ao alcance das crianças.");
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
            case "Telefones":
                content = Html.fromHtml("<h1><font color='#ff3b3e'>Em todo o Brasil:</font></h1>" +
                        "Serviço de atendimento móvel de urgência (SAMU): <b><font color='#ff3b3e'>192</font></b>" +
                        "<br />Polícia Militar (PM): <b><font color='#ff3b3e'>190</font></b>" +
                        "<br />Corpo de Bombeiros: <b><font color='#ff3b3e'>193</font></b>" +
                        "<br /><br /><h1><font color='#ff3b3e'>Em Campinas - SP:</font></h1>" +
                        "CIATox UNICAMP: <b><font color='#ff3b3e'>(19) 3521-7555</b></font>");
                break;
        }
        b.putCharSequence("content", content);
        fragment1.setArguments(b);

        mFAB = findViewById(R.id.fab_deafault);

        final QuizFragment fragment3 = new QuizFragment();
        fragmentList.add(fragment1);

        if (!title.equals("Telefones")) {
            fragmentList.add(fragment3);
        }  else {
            mFAB.setVisibility(View.INVISIBLE);
        }

        ImageButton btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
