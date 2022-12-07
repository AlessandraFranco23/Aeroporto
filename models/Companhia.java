package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import db.DAO;
import static db.SQL.DELETE_COMPANHIA;
import static db.SQL.INSERT_COMPANHIA;
import static db.SQL.UPDATE_COMPANHIA;
import static db.SQL.SELECT_COMPANHIA;
import static db.SQL.SELECT_COMPANHIA_ID;

public class Companhia {
    private Integer id;
    private String nome;
    private String cnpj;

    public Companhia() {
    }

    public Companhia(Integer id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Companhia(String nome, String cnpj) throws Exception {
        this.nome = nome;
        this.cnpj = cnpj;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_COMPANHIA);
        stmt.setNull(1, Types.INTEGER);

        stmt.setString(2, nome);
        stmt.setString(3, cnpj);
        stmt.execute();
        DAO.closeConnection();
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
        return "Companhia{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Companhia)) {
            return false;
        }
        Companhia companhia = (Companhia) o;
        return Objects.equals(id, companhia.id) && Objects.equals(nome, companhia.nome)
                && Objects.equals(cnpj, companhia.cnpj);
    }

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_COMPANHIA);
        stmt.setString(1, nome);
        stmt.setString(2, cnpj);
        stmt.setInt(3, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_COMPANHIA);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public Companhia getById(Integer id) {
        try {

            PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_COMPANHIA_ID);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Companhia(id, rs.getString("nome"), rs.getString("CNPJ"));
            }

        } catch (SQLException e) {
        }
        return null;
    }

    public List<Companhia> getAll() throws SQLException {
        List<Companhia> companhias = new ArrayList<>();
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_COMPANHIA);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Companhia companhia = new Companhia(
                    rs.getInt("idCompanhia"),
                    rs.getString("nome"),
                    rs.getString("cnpj"));
            companhias.add(companhia);
            DAO.closeConnection();
        }
        return companhias;
    }
}