package pl.androidlist.androidlist.Model;

import java.util.Date;

/**
 * Created by Makarion on 2018-11-21.
 */

public class Wyjazd {
    private int id;
    private String dataWyjazdu;
    private String dataPowrotu;
    private String cena;
    private String lokalizacja;
    private byte [] image;

    public Wyjazd(int id, String dataWyjazdu, String dataPowrotu, String cena, String lokalizacja, byte[] image) {
        this.id = id;
        this.dataWyjazdu = dataWyjazdu;
        this.dataPowrotu = dataPowrotu;
        this.cena = cena;
        this.lokalizacja = lokalizacja;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataWyjazdu() {
        return dataWyjazdu;
    }

    public void setDataWyjazdu(String dataWyjazdu) {
        this.dataWyjazdu = dataWyjazdu;
    }

    public String getDataPowrotu() {
        return dataPowrotu;
    }

    public void setDataPowrotu(String dataPowrotu) {
        this.dataPowrotu = dataPowrotu;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
