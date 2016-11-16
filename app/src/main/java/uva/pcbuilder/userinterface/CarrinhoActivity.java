package uva.pcbuilder.userinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.Hardware;
import uva.pcbuilder.userinterface.adapters.CarrinhoAdapter;
import uva.pcbuilder.userinterface.adapters.HardwareAdapter;

public class CarrinhoActivity extends AppCompatActivity {

    private Computer computadorCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Intent i = getIntent();
        computadorCustom = (Computer) i.getSerializableExtra(MainActivity.EXTRA_COMPUTER);

        ListView listView = (ListView) findViewById(R.id.listViewCarrinho);
        listView.setAdapter(new CarrinhoAdapter(this, computadorCustom.toList()));
    }
}
