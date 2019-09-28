package com.example.revisao.views.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.revisao.R;
import com.example.revisao.views.model.Banda;

import static com.example.revisao.views.activity.HomeActivity.BANDA_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FotoBandaFragment extends Fragment {
    private TextView txtNomeBanda;
    private Button btnVoltar;
    private ImageView imagem;

    public FotoBandaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Implementar a lógica de verificação dos dados recebidos e setar o nome da banda no textView
        //Implementar a lógica de ação do botão voltar

        View view = inflater.inflate(R.layout.fragment_foto_banda, container, false);

        initViews(view);

        if (!getArguments().isEmpty()){

            Banda banda = getArguments().getParcelable(BANDA_KEY);

            if (banda != null){
                Drawable drawable = getResources().getDrawable(banda.getImagem());

                imagem.setImageDrawable(drawable);
                txtNomeBanda.setText(banda.getNome());
            }
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;

    }



    public void initViews(View view){
        txtNomeBanda = view.findViewById(R.id.textViewNomeBanda);
        btnVoltar = view.findViewById(R.id.btnVoltar);
        imagem = view.findViewById(R.id.imageView);
    }


}
