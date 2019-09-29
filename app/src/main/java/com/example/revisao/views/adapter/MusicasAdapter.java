package com.example.revisao.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.views.model.Musicas;

import java.util.List;

public class MusicasAdapter extends RecyclerView.Adapter<MusicasAdapter.ViewHolder> {

    private List<Musicas> listaMusicas;

    public MusicasAdapter(List<Musicas> listaMusicas) {
        this.listaMusicas = listaMusicas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Musicas musica = listaMusicas.get(position);
        viewHolder.onBind(musica);

    }

    @Override
    public int getItemCount() {
        return listaMusicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeMusica;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeMusica = itemView.findViewById(R.id.nomeMusica);
        }

        public void onBind(Musicas musica){
            nomeMusica.setText(musica.getNomeMusica());

        }
    }
}
