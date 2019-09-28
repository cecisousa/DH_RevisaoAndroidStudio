package com.example.revisao.views.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.revisao.R;
import com.example.revisao.views.interfaces.Comunicador;
import com.example.revisao.views.model.Banda;

/**
 * A simple {@link Fragment} subclass.
 */
public class BandaFragment extends Fragment {
    private Button btnVerFoto;
    private Comunicador comunicador;


    //Sobreescever o método onAttach e implementar a lógica de inicialização do atributo do tipo Comunicador

    public BandaFragment() {
        // Required empty public constructor
    }

    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {
            comunicador = (Comunicador) context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Invocar o método da interface através do atributo comunicador

        //Implementar a lógica de ação do botão ver foto

        View view = inflater.inflate(R.layout.fragment_banda, container, false);

        initViews(view);

        btnVerFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banda banda = new Banda(R.drawable.aerosmith, "Aerosmith");
                comunicador.recebeMensagem(banda);
            }
        });


        return view;


    }

    public void initViews(View view){
        btnVerFoto = view.findViewById(R.id.btnVerFoto);

    }

}
