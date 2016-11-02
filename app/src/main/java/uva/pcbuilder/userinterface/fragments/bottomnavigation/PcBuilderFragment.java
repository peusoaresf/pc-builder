package uva.pcbuilder.userinterface.fragments.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import uva.pcbuilder.fuzzylogic.fuzzycontrollers.VgaFuzzySystem;
import uva.pcbuilder.userinterface.MainActivity;
import uva.pcbuilder.R;

public class PcBuilderFragment extends Fragment implements View.OnClickListener{

    private FrameLayout fragmentContainer;

    private EditText editTextOrcamento;
    private Button btnMontarPc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pc_builder, container, false);

//        setHasOptionsMenu(true);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_pc_builder);

        btnMontarPc = (Button) view.findViewById(R.id.btnMontarPc);
        btnMontarPc.setOnClickListener(this);

        editTextOrcamento = (EditText) view.findViewById(R.id.editTextOrcamento);
//        editTextOrcamento.addTextChangedListener(new NumberTextWatcher(editTextOrcamento, "#,###"));

//        ( (MainActivity) getActivity()).getSupportActionBar().hide();

        return view;
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            ((MainActivity)getActivity()).getSupportActionBar().setShowHideAnimationEnabled(false);
            ((MainActivity)getActivity()).getSupportActionBar().hide();
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {

            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMontarPc:
                float orcamento = Float.parseFloat(editTextOrcamento.getText().toString());
                VgaFuzzySystem vgaFuzzySystem = new VgaFuzzySystem();
                float precoVGA = vgaFuzzySystem.calcularValorMaximo(orcamento);
                Toast.makeText(this.getActivity(), "Preço VGA: " + precoVGA, Toast.LENGTH_LONG).show();
                break;
        }
    }
}