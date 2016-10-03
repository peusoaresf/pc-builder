package uva.pcbuilder.fragments;

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

import uva.pcbuilder.R;
import uva.pcbuilder.fuzzysystems.vga.FuzzySystemVGA;

public class FragmentPcBuilder extends Fragment implements View.OnClickListener{

    private FrameLayout fragmentContainer;

    private EditText editTextOrcamento;
    private Button btnMontarPc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pc_builder, container, false);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_pc_builder);

        btnMontarPc = (Button) view.findViewById(R.id.btnMontarPc);
        btnMontarPc.setOnClickListener(this);

        editTextOrcamento = (EditText) view.findViewById(R.id.editTextOrcamento);
//        editTextOrcamento.addTextChangedListener(new NumberTextWatcher(editTextOrcamento, "#,###"));

        return view;
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
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
                FuzzySystemVGA fuzzySystemVGA = new FuzzySystemVGA();
                float precoVGA = fuzzySystemVGA.calcularValorMaximo(orcamento);
                Toast.makeText(this.getActivity(), "Preço VGA: " + precoVGA, Toast.LENGTH_LONG).show();
                break;
        }
    }
}