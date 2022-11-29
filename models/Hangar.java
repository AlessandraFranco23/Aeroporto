package models;
public class Hangar {
    private Integer id;
    private String local;
    private Aviao aviao;

    public Hangar(
            Integer id,
            String local){
        this.id = id;       
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Aviao getAviao() {
        return this.aviao;
    }

    public void setAviao(String Aviao) {
        this.aviao = aviao;
    }
}