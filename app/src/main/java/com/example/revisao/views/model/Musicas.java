package com.example.revisao.views.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Musicas implements Parcelable {

    private String nomeMusica;
    private String letraMusica;

    public Musicas() {

    }

    public Musicas(String nomeMusica, String letraMusica) {
        this.nomeMusica = nomeMusica;
        this.letraMusica = letraMusica;
    }

    protected Musicas(Parcel in) {
        nomeMusica = in.readString();
        letraMusica = in.readString();
    }

    public static final Creator<Musicas> CREATOR = new Creator<Musicas>() {
        @Override
        public Musicas createFromParcel(Parcel in) {
            return new Musicas(in);
        }

        @Override
        public Musicas[] newArray(int size) {
            return new Musicas[size];
        }
    };

    public String getNomeMusica() {
        return nomeMusica;
    }

    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }

    public String getLetraMusica() {
        return letraMusica;
    }

    public void setLetraMusica(String letraMusica) {
        this.letraMusica = letraMusica;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomeMusica);
        dest.writeString(letraMusica);
    }
}
