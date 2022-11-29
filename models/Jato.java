package models;
public class Jato extends Aeronave {
    private int velocidade;
    private String cor;

    public Jato() {
    }

    public Jato(Integer id, String marca, String modelo, int velocidade, String cor) {
        super(id, marca, modelo);
        this.velocidade = velocidade;
        this.cor = cor;
    }

    public Jato( String marca, String modelo, int velocidade, String cor) {
        super( marca, modelo);
        this.velocidade = velocidade;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Jato [" + super.toString() + "velocidade =" + velocidade + "]";
    }


    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
