package uva.pcbuilder.userinterface.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by peuso on 02/10/2016.
 */

public class BottomViewPagerAdapter extends FragmentPagerAdapter {
    // Adapter para a navegação entre abas inferiores

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private Fragment currentFragment;

    public BottomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment frag) {
        this.fragments.add(frag);
    }

    // Retorna o fragmento corrente
    public Fragment getCurrentFragment() {
        return currentFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        if (getCurrentFragment() != object) {
            currentFragment = ((Fragment) object);
        }
        super.setPrimaryItem(container, position, object);
    }
}
