package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compania {
    private Integer id;
    private String nome;
    private String cnpj;

    public Compania() {
    }

    public Compania(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Compania(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Compania{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Compania)) {
            return false;
        }
        Compania compania = (Compania) o;
        return Objects.equals(id, compania.id) && Objects.equals(nome, compania.nome)
                && Objects.equals(cnpj, compania.cnpj);
    }

    public void update(){

    }

    public void delete() {}
    
    public Compania getById(Integer id) {
        return null;
    }

    public List<Compania> getAll() {
        return new ArrayList<Compania>();
    }
}