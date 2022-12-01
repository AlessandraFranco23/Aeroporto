package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import core.Search;
import db.DAO;
import db.Database;

import static db.SQL.DELETE_VOO;
import static db.SQL.INSERT_VOO;
import static db.SQL.UPDATE_VOO;
import static db.SQL.SELECT_VOO;
import static db.SQL.SELECT_VOO_ID;

public class Voo extends Search implements Database {
    private Integer id;
    private String numero;
    private String data;
    private String hora;
    private String origem;
    private String destino;
    private String piloto;
    private String copiloto;
    private String observação;
    private Integer idPista;
    private Pista pista;
    private Integer idAviao;
    private Aviao aviao;
    private Integer idHelicoptero;
    private Helicoptero helicoptero;
    private Integer idJato;
    private Jato jato;


    public Voo() {
    }


    public Voo(Integer id, String numero, String data, String hora, String origem, String destino, String piloto, String copiloto, String observação, Integer idPista, Pista pista, Integer idAviao, Aviao aviao, Integer idHelicoptero, Helicoptero helicoptero, Integer idJato, Jato jato) {
        this.id = id;
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observação = observação;
        this.idPista = idPista;
        this.pista = pista;
        this.idAviao = idAviao;
        this.aviao = aviao;
        this.idHelicoptero = idHelicoptero;
        this.helicoptero = helicoptero;
        this.idJato = idJato;
        this.jato = jato;
    }

    public Voo(String numero, String data, String hora, String origem, String destino, String piloto,
            String copiloto, String observação, Integer idPista, Pista pista, Integer idAviao, Aviao aviao,
            Integer idHelicoptero, Helicoptero helicoptero, Integer idJato, Jato jato) throws Exception {
        this.numero = numero;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.piloto = piloto;
        this.copiloto = copiloto;
        this.observação = observação;
        this.idPista = idPista;
        this.pista = pista;
        this.idAviao = idAviao;
        this.aviao = aviao;
        this.idHelicoptero = idHelicoptero;
        this.helicoptero = helicoptero;
        this.idJato = idJato;
        this.jato = jato;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_VOO);
        stmt.setString(1, numero);
        stmt.setString(2, data);
        stmt.setString(3, hora);
        stmt.setString(4, origem);
        stmt.setString(5, destino);
        stmt.setString(6, piloto);
        stmt.setString(7, copiloto);
        stmt.setString(8, observação);
        stmt.setInt(9, idPista);
        stmt.setInt(10, idAviao);
        stmt.setInt(11, idHelicoptero);
        stmt.setInt(12, idJato);
        stmt.execute();
        DAO.closeConnection();

    }

    public Voo(ResultSet result) throws Exception {
        this.id = result.getInt("id");
        this.numero = result.getString("numero");
        this.data = result.getString("data");
        this.hora = result.getString("hora");
        this.origem = result.getString("origem");
        this.destino = result.getString("destino");
        this.piloto = result.getString("piloto");
        this.copiloto = result.getString("copiloto");
        this.observação = result.getString("observação");
        this.idPista = result.getInt("idPista");
        this.pista = new Pista().getById(idPista);
        this.idAviao = result.getInt("idAviao");
        this.aviao = new Aviao().getById(idAviao);
        this.idHelicoptero = result.getInt("idHelicoptero");
        this.helicoptero = new Helicoptero().getById(idHelicoptero);
        this.idJato = result.getInt("idJato");
        this.jato = new Jato().getById(idJato);
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

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getPiloto() {
        return this.piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String getCopiloto() {
        return this.copiloto;
    }

    public void setCopiloto(String copiloto) {
        this.copiloto = copiloto;
    }

    public String getObservação() {
        return this.observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
    }

    public Integer getIdPista() {
        return this.idPista;
    }

    public void setIdPista(Integer idPista) {
        this.idPista = idPista;
    }

    public Pista getPista() {
        return this.pista;
    }

    public void setPista(Pista pista) {
        this.pista = pista;
    }

    public Integer getIdAviao() {
        return this.idAviao;
    }

    public void setIdAviao(Integer idAviao) {
        this.idAviao = idAviao;
    }

    public Aviao getAviao() {
        return this.aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Integer getIdHelicoptero() {
        return this.idHelicoptero;
    }

    public void setIdHelicoptero(Integer idHelicoptero) {
        this.idHelicoptero = idHelicoptero;
    }

    public Helicoptero getHelicoptero() {
        return this.helicoptero;
    }

    public void setHelicoptero(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }

    public Integer getIdJato() {
        return this.idJato;
    }

    public void setIdJato(Integer idJato) {
        this.idJato = idJato;
    }

    public Jato getJato() {
        return this.jato;
    }

    public void setJato(Jato jato) {
        this.jato = jato;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", numero='" + getNumero() + "'" +
            ", data='" + getData() + "'" +
            ", hora='" + getHora() + "'" +
            ", origem='" + getOrigem() + "'" +
            ", destino='" + getDestino() + "'" +
            ", piloto='" + getPiloto() + "'" +
            ", copiloto='" + getCopiloto() + "'" +
            ", observação='" + getObservação() + "'" +
            ", idPista='" + getIdPista() + "'" +
            ", pista='" + getPista() + "'" +
            ", idAviao='" + getIdAviao() + "'" +
            ", aviao='" + getAviao() + "'" +
            ", idHelicoptero='" + getIdHelicoptero() + "'" +
            ", helicoptero='" + getHelicoptero() + "'" +
            ", idJato='" + getIdJato() + "'" +
            ", jato='" + getJato() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voo)) {
            return false;
        }
        Voo voo = (Voo) o;
        return Objects.equals(id, voo.id) && Objects.equals(numero, voo.numero) && Objects.equals(data, voo.data) && Objects.equals(hora, voo.hora) && Objects.equals(origem, voo.origem) && Objects.equals(destino, voo.destino) && Objects.equals(piloto, voo.piloto) && Objects.equals(copiloto, voo.copiloto) && Objects.equals(observação, voo.observação) && Objects.equals(idPista, voo.idPista) && Objects.equals(pista, voo.pista) && Objects.equals(idAviao, voo.idAviao) && Objects.equals(aviao, voo.aviao) && Objects.equals(idHelicoptero, voo.idHelicoptero) && Objects.equals(helicoptero, voo.helicoptero) && Objects.equals(idJato, voo.idJato) && Objects.equals(jato, voo.jato);
    }

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_VOO);
        stmt.setString(1, numero);
        stmt.setString(2, data);
        stmt.setString(3, hora);
        stmt.setString(4, origem);
        stmt.setString(5, destino);
        stmt.setString(6, piloto);
        stmt.setString(7, copiloto);
        stmt.setString(8, observação);
        stmt.setInt(9, idPista);
        stmt.setInt(10, idAviao);
        stmt.setInt(11, idHelicoptero);
        stmt.setInt(12, idJato);
        stmt.setInt(13, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_VOO);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public Voo getById(Integer id) throws Exception {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_VOO_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Voo voo = new Voo(rs);
            DAO.closeConnection();
            return voo;
        }
        DAO.closeConnection();
        return null;

    }

    public List<Voo> getAll() throws Exception {
        List<Voo> voos = new ArrayList<Voo>();
        ResultSet rs = DAO.createConnection().createStatement().executeQuery(SELECT_VOO);
        while (rs.next()) {
            Voo voo = new Voo(rs);
            voos.add(voo);
        }
        DAO.closeConnection();
        return voos;

    }
}
