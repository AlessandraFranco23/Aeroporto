package models;
public abstract class Aeronave {
    public Integer id;
    public String marca;
    public String modelo;

    public Aeronave() {
    }

    public Aeronave(Integer id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }

    protected Aeronave(
            String marca,
            String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Aeronave [id=" + id + "\n"
                + " marca=" + marca + "\n"
                + "modelo=" + modelo + "]";
    }
}