package uva.pcbuilder;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import java.util.ArrayList;

import uva.pcbuilder.fragments.FragmentFavoritos;
import uva.pcbuilder.fragments.FragmentPartPicker;
import uva.pcbuilder.fragments.FragmentPcBuilder;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment;
    private FragmentPcBuilder fragmentPcBuilder = new FragmentPcBuilder();
    private FragmentFavoritos fragmentFavoritos = new FragmentFavoritos();
    private FragmentPartPicker fragmentPartPicker = new FragmentPartPicker();

    private BottomViewPagerAdapter bottomViewPagerAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();

    // UI
    private AHBottomNavigationViewPager viewPagerBottom;
    private AHBottomNavigation bottomNavigation;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        viewPagerBottom = (AHBottomNavigationViewPager) findViewById(R.id.view_pager_bottom);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floating_action_button);

        //Aqui onde é adicionado os fragments no bottom
        viewPagerBottom.setOffscreenPageLimit(2);
        bottomViewPagerAdapter = new BottomViewPagerAdapter(getSupportFragmentManager());
        bottomViewPagerAdapter.add(fragmentPcBuilder);
        bottomViewPagerAdapter.add(fragmentFavoritos);
        bottomViewPagerAdapter.add(fragmentPartPicker);
        viewPagerBottom.setAdapter(bottomViewPagerAdapter);

        currentFragment = bottomViewPagerAdapter.getCurrentFragment();

        AHBottomNavigationItem itemPcBuilder = new AHBottomNavigationItem(R.string.tab_pc_builder, R.drawable.ic_pc_builder, R.color.colorPrimary);
        AHBottomNavigationItem itemFavoritos = new AHBottomNavigationItem(R.string.tab_favoritos, R.drawable.ic_favorites, R.color.colorPrimary);
        AHBottomNavigationItem itemPartPicker = new AHBottomNavigationItem(R.string.tab_part_picker, R.drawable.ic_part_picker, R.color.colorPrimary);

        bottomNavigationItems.add(itemPcBuilder);
        bottomNavigationItems.add(itemFavoritos);
        bottomNavigationItems.add(itemPartPicker);

        bottomNavigation.addItems(bottomNavigationItems);

        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (currentFragment == null) {
                    currentFragment = bottomViewPagerAdapter.getCurrentFragment();
                }

                if (currentFragment != null) {
                    if (currentFragment instanceof FragmentFavoritos) {
                        fragmentFavoritos.willBeHidden();
                    }
                    else if (currentFragment instanceof FragmentPartPicker) {
                        fragmentPartPicker.willBeHidden();
                    }
                    else if (currentFragment instanceof FragmentPcBuilder) {
                        fragmentPcBuilder.willBeHidden();
                    }
                }

                //Aqui é onde é setado qual o fragment atual
                //Em seguida é pego o fragment atual e feito o fade dependendo de qual instancia for
                viewPagerBottom.setCurrentItem(position, false);

                currentFragment = bottomViewPagerAdapter.getCurrentFragment();

                if (currentFragment instanceof FragmentFavoritos) {
                    fragmentFavoritos.willBeDisplayed();
                }
                else if (currentFragment instanceof FragmentPartPicker) {
                    fragmentPartPicker.willBeDisplayed();
                }
                else if (currentFragment instanceof FragmentPcBuilder) {
                    fragmentPcBuilder.willBeDisplayed();
                }

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
                                public void onAnimationStart(Animator animation) {

                                }
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    floatingActionButton.animate()
                                            .setInterpolator(new LinearOutSlowInInterpolator())
                                            .start();
                                }
                                @Override
                                public void onAnimationCancel(Animator animation) {

                                }
                                @Override
                                public void onAnimationRepeat(Animator animation) {

                                }
                            })
                            .start();

                }
                else {
                    if (floatingActionButton.getVisibility() == View.VISIBLE) {
                        floatingActionButton.animate()
                                .alpha(0)
                                .scaleX(0)
                                .scaleY(0)
                                .setDuration(300)
                                .setInterpolator(new LinearOutSlowInInterpolator())
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {

                                    }
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        floatingActionButton.setVisibility(View.GONE);
                                    }
                                    @Override
                                    public void onAnimationCancel(Animator animation) {
                                        floatingActionButton.setVisibility(View.GONE);
                                    }
                                    @Override
                                    public void onAnimationRepeat(Animator animation) {

                                    }
                                })
                                .start();
                    }
                }

                return true;
            }
        });

        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {
                Log.d("DemoActivity", "BottomNavigation Position: " + y);
            }
        });

        bottomNavigation.setCurrentItem(1);

    }

}


//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private Button btnMontarPcParaUsuario;
//    private Button btnUsuarioMontarPc;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////
////        btnMontarPcParaUsuario = (Button) findViewById(R.id.btnMontarPcParaUsuario);
////        btnMontarPcParaUsuario.setOnClickListener(this);
////
////        btnUsuarioMontarPc = (Button) findViewById(R.id.btnUsuarioMontarPc);
////        btnUsuarioMontarPc.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//
////        Intent intent;
////
////        switch (v.getId()) {
////            case R.id.btnMontarPcParaUsuario:
////                intent = new Intent(this, FragmentFavoritos.class);
////                startActivity(intent);
////                break;
////            case R.id.btnUsuarioMontarPc:
////                intent = new Intent(this, FragmentPartPicker.class);
////                startActivity(intent);
////                break;
////        }
//    }
//}
