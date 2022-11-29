package models;
import java.util.ArrayList;
import java.util.List;

public class Aviao extends Aeronave{
    private String prefixo;
    private int capacidade;
    private Integer idCompania;
    private Compania compania;

    public Aviao() { }
    public Aviao(Integer id, 
        String marca, 
        String modelo, 
        Integer idCompania,
        Compania compania, 
        int capacidade,
        String prefixo) {
            super(id, marca, modelo);
            this.prefixo = prefixo;
            this.capacidade = capacidade;
            this.idCompania = idCompania;
            this.compania = compania;
        }
    public Aviao(String marca,
            String modelo,
            Integer idCompania,
            Compania compania,
            int capacidade,
            String prefixo) {
        super(marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.idCompania = idCompania;
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "Avião [" + super.toString() + "prefixo=" + prefixo + "]";
    }

    public String getPrefixo() {
        return this.prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }


    public int getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getIdCompania() {
        return this.idCompania;
    }

    public void setIdCompania(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public Compania getCompania() {
        return this.compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public void update(){

    }

    public void delete() {

    }

    public Aviao getById(Integer id) {
        return null;
    }

    public List<Aviao> getAll() {
        return new ArrayList<>();
    }
}
