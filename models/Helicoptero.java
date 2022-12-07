package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import db.DAO;

import static db.SQL.DELETE_HELICOPTERO;
import static db.SQL.INSERT_HELICOPTERO;
import static db.SQL.UPDATE_HELICOPTERO;
import static db.SQL.SELECT_HELICOPTERO;
import static db.SQL.SELECT_HELICOPTERO_ID;

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

    public Helicoptero(String marca, String modelo, String cor, int capacidade) throws Exception {
        super(marca, modelo);
        this.cor = cor;
        if (capacidade < 0)
            throw new Exception("Capacidade deve ser maior que 0");

        this.capacidade = capacidade;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_HELICOPTERO);
        stmt.setNull(1, Types.INTEGER);

        stmt.setString(2, marca);
        stmt.setString(3, modelo);
        stmt.setString(4, cor);
        stmt.setInt(5, capacidade);
        stmt.execute();
        DAO.closeConnection();
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

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_HELICOPTERO);
        stmt.setString(1, marca);
        stmt.setString(2, modelo);
        stmt.setString(3, cor);
        stmt.setInt(4, capacidade);
        stmt.setInt(5, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_HELICOPTERO);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public Helicoptero getById(Integer id) throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_HELICOPTERO_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Helicoptero helicoptero = new Helicoptero(id,
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getInt("capacidade"));
            DAO.closeConnection();
            return helicoptero;
        }
        DAO.closeConnection();
        return null;
    }

    public List<Helicoptero> getAll() throws SQLException {
        List<Helicoptero> helicopteros = new ArrayList<Helicoptero>();
        ResultSet rs = DAO.createConnection().createStatement().executeQuery(SELECT_HELICOPTERO);
        while (rs.next()) {
            Helicoptero helicoptero = new Helicoptero(
                    rs.getInt("idHelicoptero"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getInt("capacidade"));
            helicopteros.add(helicoptero);
        }
        DAO.closeConnection();
        return helicopteros;
    }
}