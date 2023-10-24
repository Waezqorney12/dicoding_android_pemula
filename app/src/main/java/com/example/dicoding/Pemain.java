package com.example.dicoding;

import android.os.Parcel;
import android.os.Parcelable;

public class Pemain implements Parcelable {
    private String _nama;
    private String _deskripsi;
    private Integer _photo;

    public Pemain() {

    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_deskripsi() {
        return _deskripsi;
    }

    public void set_deskripsi(String _deskripsi) {
        this._deskripsi = _deskripsi;
    }

    public Integer get_photo() {
        return _photo;
    }

    public void set_photo(Integer _photo) {
        this._photo = _photo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._nama);
        dest.writeString(this._deskripsi);
        dest.writeInt(this._photo);
    }


    Pemain(Parcel in){
        this._nama = in.readString();
        this._deskripsi = in.readString();
        this._photo = in.readInt();
    }

    public static final Parcelable.Creator<Pemain> CREATOR = new Parcelable.Creator<Pemain>() {
        @Override
        public Pemain createFromParcel(Parcel source) {
            return new Pemain(source);
        }
        @Override
        public Pemain[] newArray(int size) {
            return new Pemain[size];
        }
    };
}
