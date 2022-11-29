package models;
import java.util.ArrayList;
import java.util.List;

public class Helicoptero extends Aeronave {
    private String cor;
    private int capacidade;


    public Helicoptero() {
    }
    
    public Helicoptero(Integer id, String marca, String modelo, String cor, int capacidade) {
        super(id, marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }

    public Helicoptero( String marca, String modelo, String cor, int capacidade) {
        super(marca, modelo);
        this.cor = cor;
        this.capacidade = capacidade;
    }


    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Helicoptero{" +
                "cor='" + cor + '\'' +
                ", capacidade=" + capacidade +
                "} ";
    }

    public void update() {}
    public void delete() {}

    public Helicoptero getById(Integer id) {
        return null;
    }

    public List<Helicoptero> getAll() {
        return new ArrayList<>();
    }
}