package com.example.revisao.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.revisao.R;
import com.example.revisao.views.interfaces.RecyclerViewOnClick;
import com.example.revisao.views.model.Musicas;

import java.util.List;

public class MusicasAdapter extends RecyclerView.Adapter<MusicasAdapter.ViewHolder> {

    private List<Musicas> listaMusicas;
    private RecyclerViewOnClick listener;

    public MusicasAdapter(List<Musicas> listaMusicas, RecyclerViewOnClick listener) {
        this.listaMusicas = listaMusicas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Musicas musica = listaMusicas.get(position);
        holder.onBind(musica);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(musica);
            }
        });

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
