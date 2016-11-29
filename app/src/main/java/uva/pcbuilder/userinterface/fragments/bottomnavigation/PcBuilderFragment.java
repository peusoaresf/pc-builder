package uva.pcbuilder.userinterface.fragments.bottomnavigation;

import android.content.Intent;
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

import java.util.List;

import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.Hardware;
import uva.pcbuilder.fuzzylogic.fuzzycontrollers.VgaFuzzySystem;
import uva.pcbuilder.partpickers.PcBuilder;
import uva.pcbuilder.userinterface.CarrinhoActivity;
import uva.pcbuilder.userinterface.MainActivity;
import uva.pcbuilder.R;

public class PcBuilderFragment extends Fragment implements View.OnClickListener {

    // Tela da tela de montagem automatica de computadores

    private FrameLayout fragmentContainer;

    private EditText editTextOrcamento;
    private Button btnMontarPc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pc_builder, container, false);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_pc_builder);

        btnMontarPc = (Button) view.findViewById(R.id.btnMontarPc);
        btnMontarPc.setOnClickListener(this);

        editTextOrcamento = (EditText) view.findViewById(R.id.editTextOrcamento);

        return view;
    }

    // Metodo chamado ao mostrar a tela
    public void willBeDisplayed() {
        if (fragmentContainer != null) {
            ((MainActivity) getActivity()).getSupportActionBar().setShowHideAnimationEnabled(false);
            ((MainActivity) getActivity()).getSupportActionBar().hide();
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    // Metodo chamado ao esconder a tela
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
                if (orcamento < 800) {
                    Toast.makeText(this.getActivity(), "Orçamento deve ser maior ou igual a 800", Toast.LENGTH_SHORT).show();
                }
                else {
                    PcBuilder pcBuilder = new PcBuilder(v.getContext());
                    Computer c = pcBuilder.buildComputer(orcamento);

                    if (c.toList().isEmpty()) {
                        Toast.makeText(this.getActivity(), "Não foi possível montar o computador", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(getActivity(), CarrinhoActivity.class);
                        i.putExtra(MainActivity.EXTRA_COMPUTER, c);
                        startActivity(i);
                    }
                }
                break;
        }
    }
}