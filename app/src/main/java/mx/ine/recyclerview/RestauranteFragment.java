package mx.ine.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class RestauranteFragment extends Fragment {

    RecyclerView recyclerView = null;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restaurantesList;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //lista de restaurantes
            restaurantesList = new ArrayList<>();
            restaurantesList.add(new Restaurante("Pizzeria Carlos 1", "", 4.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 2", "https://www.fondodeolla.com/files/image/20/20297/55f9ad46a804b_777_559!.jpg?s=cdbc93225d6124c3f25244c4ce246626", 3.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 3", "https://aristides.online/wp-content/uploads/2015/10/Pizzeria-al-Lago-Arsie.jpg ", 2.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 4", "https://josecho.com.mx/wp-content/uploads/2016/08/Restaurante-Josecho-14.jpg", 1.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 5", "https://www.restaurantes.com/blog/wp-content/uploads/2016/09/Restaurante-de-comida-r%C3%A1pida-1050x600.jpg", 4.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 6", "https://www.hotelhaciendadeguadalupe.mx/images/hotel/rest/1.jpg", 3.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 7", "https://ep01.epimg.net/internacional/imagenes/2017/08/03/mundo_global/1501784489_469274_1501784696_noticia_normal.jpg", 2.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 8", "https://hotelsantsmetges.com/img_contenido/Restaurant%20Atempo/051ok.jpg", 1.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 9", "https://i2.wp.com/trezerestaurante.com/files/2018/10/nuevo_treze04.jpg", 4.0f, "tlalpan, DF"));
            restaurantesList.add(new Restaurante("Pizzeria Carlos 10", "https://www.granplazahotelacapulco.com/wp-content/uploads/sites/53/2017/05/Gran-Plaza-Hotel-Acapulco-Restaurante-Los-Arcos-1024x685.jpg", 3.0f, "tlalpan, DF"));

            //asociamos el adaptador al recyclerView
            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(restaurantesList, mListener);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurante item);
    }
}
