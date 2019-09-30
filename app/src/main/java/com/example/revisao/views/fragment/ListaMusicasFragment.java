package com.example.revisao.views.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revisao.R;
import com.example.revisao.views.adapter.MusicasAdapter;
import com.example.revisao.views.model.Musicas;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMusicasFragment extends Fragment {

    private RecyclerView recyclerView;
    private MusicasAdapter adapter;
    private List<Musicas> listaMusicas = new ArrayList<>();


    public ListaMusicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_lista_musicas, container, false);

        initViews(view);

        adapter = new MusicasAdapter(recebeListaMusicas());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    public void initViews(View view){
        recyclerView = view.findViewById(R.id.listaMusicasRecyclerView);
    }

    public List<Musicas> recebeListaMusicas(){
        listaMusicas.add(new Musicas("Pink"));
        listaMusicas.add(new Musicas("Crazy"));
        listaMusicas.add(new Musicas("Cryin"));
        listaMusicas.add(new Musicas("Janie's Got a Gun"));
        listaMusicas.add(new Musicas("Fly Away From Here"));
        listaMusicas.add(new Musicas("Livin' on the Edge"));
        listaMusicas.add(new Musicas("Girls of Summer"));
        listaMusicas.add(new Musicas("The Other Side"));
        listaMusicas.add(new Musicas("Dude"));
        listaMusicas.add(new Musicas("Amazing"));

        return listaMusicas;
    }

}

