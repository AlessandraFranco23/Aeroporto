package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pista {
    private Integer id;
    private String numero;

    public Pista() {
    }

    public Pista(
            Integer id,
            String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Pista(String numero) {
        this.numero = numero;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numero='" + getNumero() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pista)) {
            return false;
        }
        Pista pista = (Pista) o;
        return Objects.equals(id, pista.id) && Objects.equals(numero, pista.numero);
    }

    public void update() {

    }

    public void delete() {
    }

    public Pista getById(Integer id) {
        return null;
    }

    public List<Pista> getAll() {
        return new ArrayList<Pista>();
    }
}
