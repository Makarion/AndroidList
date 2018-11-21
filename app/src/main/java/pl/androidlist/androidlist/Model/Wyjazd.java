package pl.androidlist.androidlist.Model;

import java.util.Date;

/**
 * Created by Makarion on 2018-11-21.
 */

public class Wyjazd {
    private Long id;
    private Date dataWyjazdu;
    private Date dataPowrotu;
    private double cena;
    private String lokalizacja;

    @Override
    public String toString() {
        return "Wyjazd{" +
                "id=" + id +
                ", dataWyjazdu=" + dataWyjazdu +
                ", dataPowrotu=" + dataPowrotu +
                ", cena=" + cena +
                ", lokalizacja='" + lokalizacja + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataWyjazdu() {
        return dataWyjazdu;
    }

    public void setDataWyjazdu(Date dataWyjazdu) {
        this.dataWyjazdu = dataWyjazdu;
    }

    public Date getDataPowrotu() {
        return dataPowrotu;
    }

    public void setDataPowrotu(Date dataPowrotu) {
        this.dataPowrotu = dataPowrotu;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }
}
