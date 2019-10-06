package com.example.revisao.views.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.views.adapter.MusicasAdapter;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musicas;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMusicasFragment extends Fragment implements RecyclerViewOnClick {

    private RecyclerView recyclerView;
    private MusicasAdapter adapter;
    private List<Musicas> listaMusicas = new ArrayList<>();
    public static final String LETRA_KEY = "letra";


    public ListaMusicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_lista_musicas, container, false);

        initViews(view);

        adapter = new MusicasAdapter(recebeListaMusicas(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;

    }

    public void initViews(View view){
        recyclerView = view.findViewById(R.id.listaMusicasRecyclerView);
    }

    public List<Musicas> recebeListaMusicas(){
        listaMusicas.add(new Musicas("Pink", "Pink it's my new obsession\n" +
                "Yeah, pink it's not even a question\n" +
                "Pink on the lips of your lover, cause\n" +
                "Pink is the love you discovah\n" +
                "Pink as the bing on your cherry\n" +
                "Pink cause you are so very\n" +
                "Pink it's the color of passion\n" +
                "A-cause today\\n\"" +
                "It just goes with the fashion"));
        listaMusicas.add(new Musicas("Crazy", "Come here, baby\n" +
                "You know you drive me up the wall\n" +
                "The way you make good on all the nasty tricks you pull\n" +
                "Seems like we're makin' up more than we're makin' love\n" +
                "And it always seems you got somethin' on your mind other than me\n" +
                "Girl, you got to change your crazy ways\n" +
                "You hear me?"));
        listaMusicas.add(new Musicas("Cryin", "There was a time\n" +
                "When I was so broken hearted\n" +
                "Love wasn't much of a friend of mine\n" +
                "The tables have turned, yeah\n" +
                "'Cause me and them ways have parted\n" +
                "That kind of love was the killin' kind\n" +
                "Listen!\n" +
                "All I want is someone I can't resist\n" +
                "I know all I need to know by the way that I got kissed"));
        listaMusicas.add(new Musicas("Livin' on the Edge", "There's somethin' wrong with the world today\n" +
                "I don't know what it is\n" +
                "Something's wrong with our eyes\n" +
                "We're seein' things in a different way\n" +
                "And God knows it ain't his\n" +
                "It sure ain't no surprise\n" +
                "Livin' on the edge\n" +
                "Livin' on the edge\n" +
                "Livin' on the edge\n" +
                "Livin' on the edge"));
        listaMusicas.add(new Musicas("The Other Side", "Workin' like a dog for the boss man\n" +
                "Workin' for the company\n" +
                "I'm bettin' on the dice I'm tossin'\n" +
                "I'm gonna have a fantasy\n" +
                "But where am I gonna look\n" +
                "They tell me that love is blind\n" +
                "I really need a girl like an open book\n" +
                "To read between the lines\n" +
                "Love in an elevator\n" +
                "Livin' it up when I'm goin' down\n" +
                "Love in an elevator\n" +
                "Lovin' it up till I hit the ground"));
        listaMusicas.add(new Musicas("Dude", "(That, that) dude looks like a lady\n" +
                "(That, that) dude looks like a lady\n" +
                "(That, that) dude looks like a lady\n" +
                "(That, that) dude looks like a lady\n" +
                "Cruised into a bar on the shore\n" +
                "Her picture graced to grime on the door\n" +
                "She a long lost love at first bite\n" +
                "Baby maybe you're wrong, but you know it's all right\n" +
                "That's right"));

        return listaMusicas;
    }


    @Override
    public void onClick(Musicas musicas) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(LETRA_KEY, musicas);

        Fragment terceiroFragment = new DetalheMusicaFragment();
        terceiroFragment.setArguments(bundle);
        replaceFragment(terceiroFragment);
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }


}

