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

        fragmentContainer = (FrameLayout) view.findViewById(R.id.activity_favoritos);

        ListView listView = (ListView) view.findViewById(R.id.listViewFavoritos);

        favoritos = dbHelper.getAllFavoriteBuilds();

        if (favoritos.isEmpty())
            favoritos.add(FavoriteBuild.createExample());

        listView.setAdapter(new FavoritoAdapter(view.getContext(), favoritos));
        listView.setOnItemClickListener(this);

        return view;
    }

    public void willBeDisplayed() {
        if (fragmentContainer != null) {
            ((MainActivity) getActivity()).getSupportActionBar().setShowHideAnimationEnabled(false);
            ((MainActivity) getActivity()).getSupportActionBar().hide();
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String nomeFavorito = "";
        if (!favoritos.isEmpty()) {
            nomeFavorito = favoritos.get(position).getNomeFavorito();
        }
        Toast.makeText(view.getContext(), "Clique no favorito: " + nomeFavorito, Toast.LENGTH_SHORT).show();
    }
}
