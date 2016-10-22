package uva.pcbuilder.userinterface.partpickertopview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoArmazenamentoFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoGabineteFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoLeitorDiscoFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoPSUFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoRAMFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoVGAFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoCPUFragment;
import uva.pcbuilder.userinterface.partpickertopview.topviewfragments.SelecaoMOBOFragment;

/**
 * Created by peuso on 22/10/2016.
 */

public class TopViewPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 8;

    private SelecaoVGAFragment selecaoVGAFragment;
    private SelecaoMOBOFragment selecaoMOBOFragment;
    private SelecaoCPUFragment selecaoCPUFragment;
    private SelecaoRAMFragment selecaoRAMFragment;
    private SelecaoPSUFragment selecaoPSUFragment;
    private SelecaoArmazenamentoFragment selecaoArmazenamentoFragment;
    private SelecaoLeitorDiscoFragment selecaoLeitorDiscoFragment;
    private SelecaoGabineteFragment selecaoGabineteFragment;

    public TopViewPagerAdapter(FragmentManager fm) {
        super(fm);
        selecaoVGAFragment = new SelecaoVGAFragment();
        selecaoMOBOFragment = new SelecaoMOBOFragment();
        selecaoCPUFragment = new SelecaoCPUFragment();
        selecaoRAMFragment = new SelecaoRAMFragment();
        selecaoPSUFragment = new SelecaoPSUFragment();
        selecaoArmazenamentoFragment = new SelecaoArmazenamentoFragment();
        selecaoLeitorDiscoFragment = new SelecaoLeitorDiscoFragment();
        selecaoGabineteFragment = new SelecaoGabineteFragment();
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
