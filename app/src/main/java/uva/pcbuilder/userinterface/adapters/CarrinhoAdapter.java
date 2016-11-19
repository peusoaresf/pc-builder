package uva.pcbuilder.userinterface.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.Hardware;

/**
 * Created by peuso on 06/11/2016.
 */

public class CarrinhoAdapter extends BaseAdapter {

    private Context context;
    private List<? extends Hardware> list;


    public CarrinhoAdapter(Context c, Computer computer) {
        this.list = computer.toList();
        this.context = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_carrinho, parent, false);
        Hardware hw = null;
        if (!list.isEmpty())
            hw = list.get(position);
        if (hw != null) {
            TextView marca = (TextView) view.findViewById(R.id.textMarcaCarrinho);
            TextView modelo = (TextView) view.findViewById(R.id.textModeloCarrinho);
            TextView preco = (TextView) view.findViewById(R.id.textPrecoCarrinho);
            marca.setText(hw.getMarca());
            modelo.setText(hw.getModelo());
            preco.setText(Float.toString(hw.getPreco()));
        }
        return view;
    }
}
