package com.example.revisao.views.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Banda implements Parcelable {

    private int imagem;
    private String nome;

    public Banda (int imagem, String nome){
        this.imagem = imagem;
        this.nome = nome;
    }

    protected Banda (Parcel in){
        imagem = in.readInt();
        nome = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest, int flags){
        dest.writeInt(imagem);
        dest.writeString(nome);
    }

    public static final Creator<Banda> CREATOR = new Creator<Banda>() {
        @Override
        public Banda createFromParcel(Parcel in) {
            return new Banda(in);
        }

        @Override
        public Banda[] newArray(int size) {
            return new Banda[size];
        }
    };


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

