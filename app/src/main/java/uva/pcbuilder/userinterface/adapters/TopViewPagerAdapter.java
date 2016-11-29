package uva.pcbuilder.userinterface.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoArmazenamentoFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoGabineteFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoLeitorDiscoFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoPSUFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoRAMFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoVGAFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoCPUFragment;
import uva.pcbuilder.userinterface.fragments.swipeviews.SelecaoMOBOFragment;

/**
 * Created by peuso on 22/10/2016.
 */

public class TopViewPagerAdapter extends FragmentPagerAdapter {
    // Adapter para navegação entre abas superiores

    private static final int TAB_COUNT = 8;

    private SelecaoVGAFragment selecaoVGAFragment;
    private SelecaoMOBOFragment selecaoMOBOFragment;
    private SelecaoCPUFragment selecaoCPUFragment;
    private SelecaoRAMFragment selecaoRAMFragment;
    private SelecaoPSUFragment selecaoPSUFragment;
    private SelecaoArmazenamentoFragment selecaoArmazenamentoFragment;
    private SelecaoLeitorDiscoFragment selecaoLeitorDiscoFragment;
    private SelecaoGabineteFragment selecaoGabineteFragment;

    public TopViewPagerAdapter(FragmentManager fm, Computer c) {
        super(fm);
        selecaoVGAFragment = new SelecaoVGAFragment();
        selecaoVGAFragment.setComputadorCustom(c);
        selecaoMOBOFragment = new SelecaoMOBOFragment();
        selecaoMOBOFragment.setComputadorCustom(c);
        selecaoCPUFragment = new SelecaoCPUFragment();
        selecaoCPUFragment.setComputadorCustom(c);
        selecaoRAMFragment = new SelecaoRAMFragment();
        selecaoRAMFragment.setComputadorCustom(c);
        selecaoPSUFragment = new SelecaoPSUFragment();
        selecaoPSUFragment.setComputadorCustom(c);
        selecaoArmazenamentoFragment = new SelecaoArmazenamentoFragment();
        selecaoArmazenamentoFragment.setComputadorCustom(c);
        selecaoLeitorDiscoFragment = new SelecaoLeitorDiscoFragment();
        selecaoLeitorDiscoFragment.setComputadorCustom(c);
        selecaoGabineteFragment = new SelecaoGabineteFragment();
        selecaoGabineteFragment.setComputadorCustom(c);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return selecaoVGAFragment;
            case 1:
                return selecaoMOBOFragment;
            case 2:
                return selecaoCPUFragment;
            case 3:
                return selecaoRAMFragment;
            case 4:
                return selecaoPSUFragment;
            case 5:
                return selecaoArmazenamentoFragment;
            case 6:
                return selecaoLeitorDiscoFragment;
            case 7:
                return selecaoGabineteFragment;
        }

        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
