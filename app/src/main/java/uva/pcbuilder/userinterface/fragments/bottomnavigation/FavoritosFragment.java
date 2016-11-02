package uva.pcbuilder.userinterface.fragments.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.FavoriteBuild;
import uva.pcbuilder.userinterface.MainActivity;
import uva.pcbuilder.userinterface.adapters.FavoritoAdapter;

public class FavoritosFragment extends Fragment implements AdapterView.OnItemClickListener {

    private FrameLayout fragmentContainer;
    private DbHelper dbHelper;

    private List<FavoriteBuild> favoritos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        dbHelper = new DbHelper(view.getContext());
//        setHasOptionsMenu(true);

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_favoritos);

        ListView listView = (ListView) view.findViewById(R.id.listViewFavoritos);

        favoritos = dbHelper.getAllFavoriteBuilds();

        listView.setAdapter(new FavoritoAdapter(view.getContext(), favoritos));
        listView.setOnItemClickListener(this);


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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String nomeFavorito = "Favorito Exemplo";
        if (!favoritos.isEmpty()) {
            nomeFavorito = favoritos.get(position).getNomeFavorito();
        }
        Toast.makeText(view.getContext(), "Clique no favorito: " + nomeFavorito, Toast.LENGTH_SHORT).show();
    }
}




//public class FavoritosFragment extends AppCompatActivity implements View.OnClickListener/*AdapterView.OnItemSelectedListener*/ {
//
////    private Spinner spinnerResolucao;
//    private Button btnMontarPc;
//    private EditText editTextOrcamento;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_favoritos);
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
////                Toast.makeText(FavoritosFragment.this, "Insert bem sucedido", Toast.LENGTH_SHORT).show();
////            else
////                Toast.makeText(FavoritosFragment.this, "Erro ao inserir novo valor", Toast.LENGTH_SHORT).show();
//
//            float orcamento = Float.parseFloat(editTextOrcamento.getText().toString());
//
////            PcBuilder pcBuilder = new PcBuilder(this);
////            Computer computador = pcBuilder.montarComputador(orcamento);
//
//            FuzzySystemVGA fuzzySystemVGA = new FuzzySystemVGA();
//            float precoVGA = fuzzySystemVGA.calcularValorMaximo(orcamento);
//
//            System.out.println(precoVGA);
//
//
//            Toast.makeText(FavoritosFragment.this, "Valor VGA: " + precoVGA, Toast.LENGTH_SHORT).show();
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
