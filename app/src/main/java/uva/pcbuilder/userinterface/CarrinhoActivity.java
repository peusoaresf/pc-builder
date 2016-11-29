package uva.pcbuilder.userinterface;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Case;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.Hardware;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.dominio.Processor;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.dominio.Storage;
import uva.pcbuilder.dominio.VideoGraphicsAdapter;
import uva.pcbuilder.userinterface.adapters.CarrinhoAdapter;
import uva.pcbuilder.util.DateHelper;

public class CarrinhoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    // Tela do "carrinho", onde é listada a lista de hardwares do pc montado automaticamente ou manualmente

    private List<? extends Hardware> list;

    private Button btnSalvarFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        btnSalvarFav = (Button) findViewById(R.id.btnSalvarFav);
        btnSalvarFav.setOnClickListener(this);

        Intent i = getIntent();
        Computer computadorCustom = (Computer) i.getSerializableExtra(MainActivity.EXTRA_COMPUTER);
        list = computadorCustom.toList();

        ListView listView = (ListView) findViewById(R.id.listViewCarrinho);
        listView.setAdapter(new CarrinhoAdapter(this, list));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ComputerSpecsDialogFragment.showDialog(getFragmentManager(), list.get(position).toString());
    }

    // É possivel salvar a build sem erro,
    // mas ao tentar recupera-la o app congela.
    // Nao houve tempo de corrigir
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSalvarFav:
                if (!list.isEmpty()) {
                    final EditText txtNomeBuild = new EditText(this);
                    new AlertDialog.Builder(this)
                            .setTitle("Salvar Favorito")
                            .setMessage("Entre com um nome para sua Build: ")
                            .setView(txtNomeBuild)
                            .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    String nomeBuild = txtNomeBuild.getText().toString();
                                    String dataFavorito = DateHelper.nowToString();
                                    int idMobo = 0;
                                    int idCpu = 0;
                                    int idODD = 0;
                                    int idCase = 0;
                                    int idPsu = 0;
                                    int idRam = 0;
                                    int idVga = 0;
                                    int idStorage = 0;

                                    for (int i = 0; i < list.size(); i++) {
                                        Hardware hw = list.get(i);
                                        if (hw instanceof Motherboard)
                                            idMobo = hw.getIdBanco();
                                        if (hw instanceof Processor)
                                            idCpu = hw.getIdBanco();
                                        if (hw instanceof OpticalDiskDriver)
                                            idODD = hw.getIdBanco();
                                        if (hw instanceof Case)
                                            idCase = hw.getIdBanco();
                                        if (hw instanceof Psu)
                                            idPsu = hw.getIdBanco();
                                        if (hw instanceof MainMemory)
                                            idRam = hw.getIdBanco();
                                        if (hw instanceof VideoGraphicsAdapter)
                                            idVga = hw.getIdBanco();
                                        if (hw instanceof Storage)
                                            idStorage = hw.getIdBanco();
                                    }

                                    DbHelper db = new DbHelper(CarrinhoActivity.this);
                                    db.insertFavoriteBuild(nomeBuild, dataFavorito, idMobo, idCpu, idODD,
                                                            idCase, idPsu, idRam, 1, idVga, 1, idStorage, 1);

                                    Toast.makeText(CarrinhoActivity.this, "Favorito salvo com sucesso!", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            })
                            .show();
                }
                else {
                    Toast.makeText(this, "Nenhum item para ser salvo.", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
