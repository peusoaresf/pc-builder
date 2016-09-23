package uva.pcbuilder.layoutcontroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.partpickers.PcBuilder;
import uva.pcbuilder.R;
import uva.pcbuilder.dominio.Computador;

public class FormularioParametrosPcActivity extends AppCompatActivity implements View.OnClickListener/*AdapterView.OnItemSelectedListener*/ {

//    private Spinner spinnerResolucao;
    private Button btnMontarPc;
    private EditText editTextOrcamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_parametros_pc);

        btnMontarPc = (Button) findViewById(R.id.btnMontarPC);
        btnMontarPc.setOnClickListener(this);

        editTextOrcamento = (EditText) findViewById(R.id.editTextOrcamento);

//        spinnerResolucao = (Spinner) findViewById(R.id.spinnerResolucao);
//
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this, R.array.resolucoes_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//
//        spinnerResolucao.setAdapter(adapter);
//        spinnerResolucao.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnMontarPC) {
            // testes no banco
//            DbHelper db = new DbHelper(this);
//            List<Motherboard> mobos = db.getAllMotherboards();
//            for(Motherboard mobo : mobos)
//                System.out.printf("%s %s %s %s %f %f\n",
//                        mobo.getMarca(), mobo.getModelo(), mobo.getCpuSocket(),
//                         mobo.getCpuSocket(), mobo.getPreco(), mobo.getConsumoEletrico());
//            if (db.insertMotherboard("Gigabyte", "GA-H110M-H", "lga1151", "ddr3", 369.9f, 40))
//                Toast.makeText(FormularioParametrosPcActivity.this, "Insert bem sucedido", Toast.LENGTH_SHORT).show();
//            else
//                Toast.makeText(FormularioParametrosPcActivity.this, "Erro ao inserir novo valor", Toast.LENGTH_SHORT).show();

            float orcamento = Float.parseFloat(editTextOrcamento.getText().toString());

            PcBuilder pcBuilder = new PcBuilder(this);
            Computador computador = pcBuilder.montarComputador(orcamento);
        }
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }

//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
