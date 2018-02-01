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
                content = Html.fromHtml("• Não deixe <font color='#ff1744'>fósforos</font>, <font color='#ff1744'>isqueiros</font>, e outros objetos que possam causar <font color='#ff1744'>fogo</font> ao alcance dos pequenos." +
                        "<br /><br />• Mantenha a criança longe da <font color='#ff1744'>cozinha</font> e do <font color='#ff1744'>fogão</font>, principalmente durante o preparo das refeições." +
                        "<br /><br />• Cozinhe nas <font color='#ff1744'>bocas</font> de trás do fogão e sempre deixe os <font color='#ff1744'>cabos das panelas</font> virados para trás." +
                        "<br /><br />• Evite carregar crianças no colo enquanto mexe em <font color='#ff1744'>panelas</font> no fogão ou manipula <font color='#ff1744'>líquidos quentes</font>." +
                        "<br /><br />• Não deixe as crianças por perto quando estiver <font color='#ff1744'>passando roupa</font>, nem largue o <font color='#ff1744'>ferro elétrico</font> sem vigilância.");
            case "Choques":
                content = Html.fromHtml("• Empinar pipa só em lugares abertos, longe de fios elétricos." +
                "<br /><br />• As tomadas devem estar protegidas por tampas apropriadas, esparadrapo, fita isolante, ou mesmo coberta por móveis");
            case "Intoxicações":
                content = Html.fromHtml("• Conheça as plantas de sua casa e remova as venenosas." +
                "<br /><br />• Certifique-se de que os brinquedos da criança são atóxicos e indicados à idade dela. Compre produtos com selo do Inmetro." +
                "<br /><br />• Saiba quais produtos domésticos são tóxicos. Produtos comuns, como enxaguantes bucais, podem ser nocivos se a criança engolir em grande quantidade." +
                "<br /><br />• Mantenha medicamentos trancados e nunca se refira a eles como 'doce'. Isto pode levar a criança a pensar que não é perigoso ou que é agradávl de comer." +
                "<br /><br />• Guarde todos os produtos de higiene e limpeza trancados, fora da vista e do alcance das crianças. A cor dos produtos e de suas embalagens pode chamar a antenção." +
                "<br /><br />• Se a criança tomar medicamentos ou produtos tóxicos, faça contato imediato com seu médico ou serviço de urgência.");
            case "Asfixia":
                content = Html.fromHtml("• Corte os alimentos em pedaços bem pequenos na hora de alimentar a criança." +
                "<br /><br />• Deixe o chão livre de objetos pequenos como botões, bolas de gude, moedas e tachinhas, para não correr o risco da criança engolir." +
                "<br /><br />• Certifique-se de que os brinquedos da criança não possuem partes pequenas e que se soltam." +
                "<br /><br />• Não deixe a criança sozinha no carro, mesmo que o vidro esteja entreaberto." +
                "<br /><br />• Brinquedos com correntes, tiras e cordas com mais de 15cm devem ser evitados.");
            case "Afogamento":
                content = Html.fromHtml("• As crianças devem sempre ser supervisionadas por um adulto quando estiverem próximas de água." +
                "<br /><br />• Instale cercas de isolamento na piscina com, no mínimo, 1,5m de altura, cadeados e travas." +
                "<br /><br />• Evite brinquedos e outros atrativos próximos a piscinas e reservatórios de água." +
                "<br /><br />• Boias e outros equipamentos infláveis passam uma falsa sensação de segurança. O ideal é que a criança use sempre um colete salva-vidas em embarcações ou na prática de esportes aquáticos." +
                "<br /><br />• Ensine a criança a não brincar de empurrar e a não simular que está se afogando." +
                "<br /><br />• Conserve a tampa do vaso sanitário fechada ou lacrada com dispositivo de segurança ou mantenha a porta do banheiro trancada." +
                "<br /><br />• Nunca deixa a criança sozinha na banheira." +
                "<br /><br />• Mantenha cisternas, tonéis, poços e outros reservatórios domésticos trancados ou com proteção." +
                "<br /><br />• Deixe os baldes com água no alto, longe do alcance das crianças, esvazie todos após o uso e guarde-os virados para baixo.");
            case "Transporte":
                content = Html.fromHtml("• Crianças com menos de 10 anos devem sentar no banco de trás do carro. Até os 7 anos, é importante usar cadeirinhas de segurança adequadas à idade e ao peso da criança. Sempre usar cinto de segurança." +
                "<br /><br />• Ao contratar transporte escolar, busque referências e verifique a documentação do veículo e do motorista.");
            case "Traumas e precauções gerais":
                content = Html.fromHtml("• Mantenha camas, armários e outros móveis longe das janelas e cortinas e verifique se estão estáveis." +
                "<br /><br />• Cuidado com a quina dos móveis." +
                "<br /><br />• Não use toalhas de mesa compridas." +
                "<br /><br />• Cuidado com pisos escorregadios, coloque antiderrapante nos tapetes." +
                "<br /><br />• Nunca deixe sacos plásticos ao alcance das crianças.");
            caase "Quedas":
                content = Html.fromHtml("• Escadas, sacadas e lajes não são lugares para brincar." +
                "<br /><br />• No parquinho, verifique se os equipamentos são apropriados à idade da criança e fique atento a perigos como ferrugem, pregos expostos e superfícies instáveis." +
                "<br /><br />• O piso dos parquinhos deve absorver o impacto, sendo de grama, emborrachado ou areia." +
                "<br /><br />• Ensine regras de comportamento, como não empurrar, nem se amontoar." +
                "<br /><br />• Ensine a criança a usar capacete quando estiver de bicicleta, skate ou patins." +
                "<br /><br />• Crianças com menos de 6 anos não devem dormir em beliches. Se não houver escolha, coloque grades de proteção nas laterais." +
                "<br /><br />• Nunca deixe um bebê sozinho em mesas, camas ou outros móveis, mesmo que seja por pouco tempo." +
                "<br /><br />• As grades de proteção do berço devem estar fixas. O vão entre as grades não deve ter mais que 6 cm de distância." +
                "<br /><br />• Remova do berço todos os brinquedos, travesseiros e objetos macios quando o bebê estiver dormindo." +
                "<br /><br />• Instale grades ou redes de proteção nas janelas, sacadas e mezaninos. As redes devem ter espaços de no máximo 6 cm." +
                "<br /><br />• Use portões de segurança no topo e na base das escadas e, caso sejam abertas, instale redes de proteção.");
            case "Atropelamento":
                content = Html.fromHtml("• Ensine a criança a respeitar os sinais de trânsito, atravessar a rua na faixa de pedestres e olhando para os dois lados." +
                "• Menores de 10 anos não devem atravessar a rua sozinhos. É importante segurar os pequenos pelo pulso." +
                "• Entradas de garagens, quintais sem cerca ou estacionamentos não são seguros para brincadeiras.");

        }
        b.putCharSequence("content", content);
        fragment1.setArguments(b);

        final QuizFragment fragment3 = new QuizFragment();
        fragmentList.add(fragment1);
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
