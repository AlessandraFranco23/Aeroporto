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

import static db.SQL.DELETE_PISTA;
import static db.SQL.INSERT_PISTA;
import static db.SQL.UPDATE_PISTA;
import static db.SQL.SELECT_PISTA;
import static db.SQL.SELECT_PISTA_ID;

public class Pista extends Search implements Database {
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

    public Pista(String numero) throws Exception {
        this.numero = numero;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_PISTA);
        stmt.setString(1, numero);
        stmt.execute();
        DAO.closeConnection();
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

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_PISTA);
        stmt.setString(1, numero);
        stmt.setInt(2, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_PISTA);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public Pista getById(Integer id) throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_PISTA_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Pista pista = new Pista(id,
                    rs.getString("numero"));
            DAO.closeConnection();
            return pista;
        }
        DAO.closeConnection();
        return null;
    }

    public List<Pista> getAll() throws SQLException {
        List<Pista> jatos = new ArrayList<Pista>();
        ResultSet rs = DAO.createConnection().createStatement().executeQuery(SELECT_PISTA);
        while (rs.next()) {
            Pista pista = new Pista(rs.getInt("idPista"),
                    rs.getString("numero"));
            jatos.add(pista);
        }
        DAO.closeConnection();
        return jatos;
    }
}
