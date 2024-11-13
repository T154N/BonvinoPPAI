package models;

import java.io.Serializable;
import java.util.Objects;

public class VinoId implements Serializable {
    private Integer aniada;
    private String nombreVino;

    public VinoId() {}

    public VinoId(Integer aniada, String nombreVino) {
        this.aniada = aniada;
        this.nombreVino = nombreVino;
    }

    // Getters, Setters, hashCode y equals

    public Integer getAniada() {
        return aniada;
    }

    public void setAniada(Integer aniada) {
        this.aniada = aniada;
    }

    public String getNombreVino() {
        return nombreVino;
    }

    public void setNombreVino(String nombreVino) {
        this.nombreVino = nombreVino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VinoId vinoId = (VinoId) o;
        return Objects.equals(aniada, vinoId.aniada) && Objects.equals(nombreVino, vinoId.nombreVino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aniada, nombreVino);
    }
}
