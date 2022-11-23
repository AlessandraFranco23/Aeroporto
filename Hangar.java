public class Hangar {
    private String local;
    private Aviao aviao;
    
    

    public Hangar(
            String local
            ){
       /*  Validator<Carro> placaValidator = new Validator<Carro>("(\\d{3})|([a-zA-Z]{4})");
        if (!placaValidator.isValid(placa))
            throw new IllegalArgumentException("Placa invalida");*/
        this.local = local;
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

    public void setVaga(String vaga) {
        this.vaga = vaga;
    }
}