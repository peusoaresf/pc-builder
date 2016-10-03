package uva.pcbuilder.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import uva.pcbuilder.R;

public class FragmentFavoritos extends Fragment {

    private FrameLayout fragmentContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_favoritos, container, false);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_favoritos);

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
}




//public class FragmentFavoritos extends AppCompatActivity implements View.OnClickListener/*AdapterView.OnItemSelectedListener*/ {
//
////    private Spinner spinnerResolucao;
//    private Button btnMontarPc;
//    private EditText editTextOrcamento;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_favoritos);
//
//        btnMontarPc = (Button) findViewById(R.id.btnMontarPC);
//        btnMontarPc.setOnClickListener(this);
//
//        editTextOrcamento = (EditText) findViewById(R.id.editTextOrcamento);
//
////        spinnerResolucao = (Spinner) findViewById(R.id.spinnerResolucao);
////
////        // Create an ArrayAdapter using the string array and a default spinner layout
////        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
////                this, R.array.resolucoes_array, android.R.layout.simple_spinner_item);
////        // Specify the layout to use when the list of choices appears
////        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        // Apply the adapter to the spinner
////
////        spinnerResolucao.setAdapter(adapter);
////        spinnerResolucao.setOnItemSelectedListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.btnMontarPC) {
//            // testes no banco
////            DbHelper db = new DbHelper(this);
////            List<Motherboard> mobos = db.getAllMotherboards();
////            for(Motherboard mobo : mobos)
////                System.out.printf("%s %s %s %s %f %f\n",
////                        mobo.getMarca(), mobo.getModelo(), mobo.getCpuSocket(),
////                         mobo.getCpuSocket(), mobo.getPreco(), mobo.getConsumoEletrico());
////            if (db.insertMotherboard("Gigabyte", "GA-H110M-H", "lga1151", "ddr3", 369.9f, 40))
////                Toast.makeText(FragmentFavoritos.this, "Insert bem sucedido", Toast.LENGTH_SHORT).show();
////            else
////                Toast.makeText(FragmentFavoritos.this, "Erro ao inserir novo valor", Toast.LENGTH_SHORT).show();
//
//            float orcamento = Float.parseFloat(editTextOrcamento.getText().toString());
//
////            PcBuilder pcBuilder = new PcBuilder(this);
////            Computador computador = pcBuilder.montarComputador(orcamento);
//
//            FuzzySystemVGA fuzzySystemVGA = new FuzzySystemVGA();
//            float precoVGA = fuzzySystemVGA.calcularValorMaximo(orcamento);
//
//            System.out.println(precoVGA);
//
//
//            Toast.makeText(FragmentFavoritos.this, "Valor VGA: " + precoVGA, Toast.LENGTH_SHORT).show();
//        }
//    }
//
////    @Override
////    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////
////    }
//
////    @Override
////    public void onNothingSelected(AdapterView<?> parent) {
////
////    }
//}
