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
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.Hardware;
import uva.pcbuilder.dominio.MainMemory;
import uva.pcbuilder.dominio.Psu;
import uva.pcbuilder.userinterface.ComputerSpecsDialogFragment;
import uva.pcbuilder.userinterface.adapters.HardwareAdapter;

/**
 * Created by peuso on 22/10/2016.
 */

public class SelecaoRAMFragment extends Fragment implements AdapterView.OnItemClickListener {

    private DbHelper dbHelper;
    private List<? extends Hardware> rams;

    private Computer computadorCustom;

    public void setComputadorCustom(Computer c) {
        computadorCustom = c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_part_picker, container, false);
        dbHelper = new DbHelper(view.getContext());

        ListView listView = (ListView) view.findViewById(R.id.listViewHardware);

        rams = dbHelper.getAllMainMemories();

        if (rams.isEmpty()) {
            rams = MainMemory.createExample();
        }

        listView.setAdapter(new HardwareAdapter(view.getContext(), rams, computadorCustom));
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ComputerSpecsDialogFragment.showDialog(getActivity().getFragmentManager(), rams.get(position).toString());
    }
}
