package uva.pcbuilder.userinterface.fragments.swipeviews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.database.DbHelper;
import uva.pcbuilder.dominio.Hardware;
import uva.pcbuilder.dominio.Motherboard;
import uva.pcbuilder.dominio.OpticalDiskDriver;
import uva.pcbuilder.userinterface.adapters.HardwareAdapter;

/**
 * Created by peuso on 22/10/2016.
 */

public class SelecaoMOBOFragment extends Fragment implements AdapterView.OnItemClickListener {

    private DbHelper dbHelper;
    private List<? extends Hardware> mobos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_part_picker, container, false);
        dbHelper = new DbHelper(view.getContext());

        ListView listView = (ListView) view.findViewById(R.id.listViewHardware);

        mobos = dbHelper.getAllMotherboards();

        if (mobos.isEmpty()) {
            mobos = Motherboard.createExample();
        }

        listView.setAdapter(new HardwareAdapter(view.getContext(), mobos));
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(view.getContext(), "Clicou no item: " + (position + 1), Toast.LENGTH_SHORT).show();
    }
}
