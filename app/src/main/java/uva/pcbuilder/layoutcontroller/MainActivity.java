package uva.pcbuilder.layoutcontroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import uva.pcbuilder.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMontarPcParaUsuario;
    private Button btnUsuarioMontarPc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMontarPcParaUsuario = (Button) findViewById(R.id.btnMontarPcParaUsuario);
        btnMontarPcParaUsuario.setOnClickListener(this);

        btnUsuarioMontarPc = (Button) findViewById(R.id.btnUsuarioMontarPc);
        btnUsuarioMontarPc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.btnMontarPcParaUsuario:
                intent = new Intent(this, FormularioParametrosPcActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUsuarioMontarPc:
                intent = new Intent(this, MontarProprioPcActivity.class);
                startActivity(intent);
                break;
        }
    }
}
