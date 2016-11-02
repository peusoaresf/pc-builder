package uva.pcbuilder.userinterface.fragments.bottomnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import uva.pcbuilder.userinterface.MainActivity;
import uva.pcbuilder.R;
import uva.pcbuilder.userinterface.adapters.TopViewPagerAdapter;

public class PartPickerFragment extends Fragment implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private FrameLayout fragmentContainer;

    private ViewPager viewPager;
    private ActionBar actionBar;
    private TopViewPagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_part_picker, container, false);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_part_picker);

        actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        mAdapter = new TopViewPagerAdapter(super.getActivity().getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.addOnPageChangeListener(this);

        String [] tabs = new String[]{"VGA", "CPU", "MOBO", "RAM", "PSU", "STORAGE", "LEITOR DISCO", "GABINETE"};

        for (String tab : tabs) {
            TextView t = new TextView(super.getActivity());
            t.setAllCaps(true);
            t.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL));
            t.setGravity(Gravity.CENTER);
            t.setTextColor(Color.WHITE);
            t.setText(tab);

            actionBar.addTab(actionBar.newTab()
                    .setCustomView(t)
                    .setTabListener(this));
        }

        return view;
    }

    public void willBeDisplayed() {
        if (fragmentContainer != null) {
            ((MainActivity)getActivity()).getSupportActionBar().setShowHideAnimationEnabled(false);
            ((MainActivity)getActivity()).getSupportActionBar().show();
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }

    /*
        Metodos referentes a mudanca de tela entre as tabs
     */
    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    /*
        Metodos referentes a mudanca das abas
     */
    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
