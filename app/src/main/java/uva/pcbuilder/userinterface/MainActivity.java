package uva.pcbuilder.userinterface;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;

import uva.pcbuilder.R;
import uva.pcbuilder.database.DbInflater;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.userinterface.adapters.BottomViewPagerAdapter;
import uva.pcbuilder.userinterface.fragments.bottomnavigation.FavoritosFragment;
import uva.pcbuilder.userinterface.fragments.bottomnavigation.PartPickerFragment;
import uva.pcbuilder.userinterface.fragments.bottomnavigation.PcBuilderFragment;

public class MainActivity extends AppCompatActivity
        implements AHBottomNavigation.OnTabSelectedListener {

    // Atributo para enviar um objeto computador para a tela do carrinho
    // a partir do floating button
    public static final String EXTRA_COMPUTER = "computador_custom";
    private Computer computadorCustom = new Computer();

    // fragments com as telas principais da navegação inferior
    private Fragment currentFragment;
    private PcBuilderFragment pcBuilderFragment = new PcBuilderFragment();
    private FavoritosFragment favoritosFragment = new FavoritosFragment();
    private PartPickerFragment partPickerFragment = new PartPickerFragment();

    // Atributos da UI
    private BottomViewPagerAdapter bottomViewPagerAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    private AHBottomNavigationViewPager viewPagerBottom;
    private AHBottomNavigation bottomNavigation;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Apenas instanciado quando for necessario inflar a base de dados
//        new DbInflater(this).inflate();

        // Computador que será preenchido na aba de escolha manual de peças
        partPickerFragment.setComputadorCustom(computadorCustom);

        startUI();

        getSupportActionBar().hide();
    }

    private void startUI() {
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        viewPagerBottom = (AHBottomNavigationViewPager) findViewById(R.id.view_pager_bottom);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);
        floatingActionButton.setImageResource(R.drawable.ic_cart);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CarrinhoActivity.class);
                i.putExtra(EXTRA_COMPUTER, computadorCustom);
                startActivity(i);
            }
        });

        //Aqui onde é adicionado os fragments no bottomview
        viewPagerBottom.setOffscreenPageLimit(2);
        bottomViewPagerAdapter = new BottomViewPagerAdapter(getSupportFragmentManager());
        bottomViewPagerAdapter.add(pcBuilderFragment);
        bottomViewPagerAdapter.add(favoritosFragment);
        bottomViewPagerAdapter.add(partPickerFragment);
        viewPagerBottom.setAdapter(bottomViewPagerAdapter);

        currentFragment = bottomViewPagerAdapter.getCurrentFragment();

        AHBottomNavigationItem itemPcBuilder = new AHBottomNavigationItem(
                R.string.tab_pc_builder, R.drawable.ic_pc_builder, R.color.colorPrimary);

        AHBottomNavigationItem itemFavoritos = new AHBottomNavigationItem(
                R.string.tab_favoritos, R.drawable.ic_favorites, R.color.colorPrimary);

        AHBottomNavigationItem itemPartPicker = new AHBottomNavigationItem(
                R.string.tab_part_picker, R.drawable.ic_part_picker, R.color.colorPrimary);

        bottomNavigationItems.add(itemPcBuilder);
        bottomNavigationItems.add(itemFavoritos);
        bottomNavigationItems.add(itemPartPicker);

        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        bottomNavigation.setOnTabSelectedListener(this);
        bottomNavigation.setCurrentItem(1);
    }

    // listener de troca de abas inferiores
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (currentFragment == null) {
            currentFragment = bottomViewPagerAdapter.getCurrentFragment();
        }

        if (currentFragment != null) {
            if (currentFragment instanceof FavoritosFragment) {
                favoritosFragment.willBeHidden();
            }
            else if (currentFragment instanceof PartPickerFragment) {
                partPickerFragment.willBeHidden();
            }
            else if (currentFragment instanceof PcBuilderFragment) {
                pcBuilderFragment.willBeHidden();
            }
        }

        //Aqui é onde é setado qual o fragment atual.
        //Em seguida é pego o fragment atual e feito o fade dependendo de qual instancia for
        viewPagerBottom.setCurrentItem(position, false);

        currentFragment = bottomViewPagerAdapter.getCurrentFragment();

        if (currentFragment instanceof FavoritosFragment) {
            favoritosFragment.willBeDisplayed();
        }
        else if (currentFragment instanceof PartPickerFragment) {
            partPickerFragment.willBeDisplayed();
        }
        else if (currentFragment instanceof PcBuilderFragment) {
            pcBuilderFragment.willBeDisplayed();
        }

        // Desenha o floating button na aba de montagem manual
        if (position == 2) {
            bottomNavigation.setNotification("", 1);

            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setAlpha(0f);
            floatingActionButton.setScaleX(0f);
            floatingActionButton.setScaleY(0f);
            floatingActionButton.animate()
                    .alpha(1)
                    .scaleX(1)
                    .scaleY(1)
                    .setDuration(300)
                    .setInterpolator(new OvershootInterpolator())
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) { }
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            floatingActionButton.animate()
                                    .setInterpolator(new LinearOutSlowInInterpolator())
                                    .start();
                        }
                        @Override
                        public void onAnimationCancel(Animator animation) { }
                        @Override
                        public void onAnimationRepeat(Animator animation) { }
                    })
                    .start();

        }
        else {
            // Se nao o esconde
            if (floatingActionButton.getVisibility() == View.VISIBLE) {
                floatingActionButton.animate()
                        .alpha(0)
                        .scaleX(0)
                        .scaleY(0)
                        .setDuration(300)
                        .setInterpolator(new LinearOutSlowInInterpolator())
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) { }
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                floatingActionButton.setVisibility(View.GONE);
                            }
                            @Override
                            public void onAnimationCancel(Animator animation) {
                                floatingActionButton.setVisibility(View.GONE);
                            }
                            @Override
                            public void onAnimationRepeat(Animator animation) { }
                        })
                        .start();
            }
        }

        return true;
    }
}
