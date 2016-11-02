package uva.pcbuilder.userinterface.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import uva.pcbuilder.R;
import uva.pcbuilder.dominio.Computer;
import uva.pcbuilder.dominio.FavoriteBuild;

/**
 * Created by peuso on 30/10/2016.
 */

public class FavoritoAdapter extends BaseAdapter {

    private Context context;
    private List<FavoriteBuild> favoritos;

    public FavoritoAdapter(Context c, List<FavoriteBuild> f) {
        this.context = c;
        this.favoritos = f;
    }

    @Override
    public int getCount() {
        return favoritos.size();
    }

    @Override
    public Object getItem(int position) {
        return favoritos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.adapter_favoritos, parent, false);
        FavoriteBuild f = favoritos.get(position);
        TextView nomeFavorito = (TextView) view.findViewById(R.id.textNomeFavorito);
        TextView dataFavorito = (TextView) view.findViewById(R.id.textDataFavorito);
        ImageView img = (ImageView) view.findViewById(R.id.imagemFavorito);
        LinearLayout lay = (LinearLayout) view.findViewById(R.id.lay);
        if (position % 2 == 0)
            lay.setBackgroundColor(Color.parseColor("#CCCCCC"));
        nomeFavorito.setText(f.getNomeFavorito());
        dataFavorito.setText(f.getDataFavorito());
        return view;
    }
}
