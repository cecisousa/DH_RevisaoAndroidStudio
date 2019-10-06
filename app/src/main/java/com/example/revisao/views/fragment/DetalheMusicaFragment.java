package com.example.revisao.views.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.revisao.R;
import com.example.revisao.views.model.Musicas;

import static com.example.revisao.views.fragment.ListaMusicasFragment.LETRA_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheMusicaFragment extends Fragment {

    private TextView nomeMusica;
    private TextView letraMusica;
    private Button btnVoltar;

    public DetalheMusicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_musica, container, false);

        initViews (view);

        if (getArguments() != null){
            Musicas musicas = getArguments().getParcelable(LETRA_KEY);

            if (musicas != null) {

                nomeMusica.setText(musicas.getNomeMusica());
                letraMusica.setText(musicas.getLetraMusica());
            }
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new ListaMusicasFragment());
            }
        });


        return view;
    }

    public void initViews(View view) {
        nomeMusica  = view.findViewById(R.id.nomeMusica);
        letraMusica  = view.findViewById(R.id.letraMusica);
        btnVoltar = view.findViewById(R.id.btnVoltar);
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

}
