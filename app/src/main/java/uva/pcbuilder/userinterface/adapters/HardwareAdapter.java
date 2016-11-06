package uva.pcbuilder.userinterface.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.dominio.Hardware;

/**
 * Created by peuso on 05/11/2016.
 */

public class HardwareAdapter extends BaseAdapter {

    private Context context;
    private List<? extends Hardware> hardwareList;

    public HardwareAdapter(Context c, List<? extends Hardware> list) {
        context = c;
        hardwareList = list;
    }

    @Override
    public int getCount() {
        return hardwareList.size();
    }

    @Override
    public Object getItem(int position) {
        return hardwareList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_hardware, parent, false);
        Button btnAdicionar = (Button) view.findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Item adicionado", Toast.LENGTH_SHORT).show();
            }
        });
        Hardware hw = hardwareList.get(position);
        TextView marcaHardware = (TextView) view.findViewById(R.id.textMarcaHardware);
        TextView modeloHardware = (TextView) view.findViewById(R.id.textModelo);
        LinearLayout lay = (LinearLayout) view.findViewById(R.id.layoutHardware);
        if (position % 2 == 0)
            lay.setBackgroundColor(Color.parseColor("#CCCCCC"));
        marcaHardware.setText(hw.getMarca());
        modeloHardware.setText(hw.getModelo());
        return view;
    }
}
