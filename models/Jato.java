package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import db.DAO;

import static db.SQL.DELETE_JATO;
import static db.SQL.INSERT_JATO;
import static db.SQL.UPDATE_JATO;
import static db.SQL.SELECT_JATO;
import static db.SQL.SELECT_JATO_ID;

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

    public Jato( String marca, String modelo, int velocidade, String cor) throws Exception {
        super( marca, modelo);
        
        if (velocidade < 0)
            throw new Exception("Velocidade deve ser maior que 0");
        this.velocidade = velocidade;
        this.cor = cor;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_JATO);
        stmt.setNull(1, Types.INTEGER);

        stmt.setString(2, marca);
        stmt.setString(3, modelo);
        stmt.setString(4, cor);
        stmt.setInt(5, velocidade);
        stmt.execute();
        DAO.closeConnection();

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

    @Override
    public Jato getById(Integer id) throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_JATO_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Jato jato = new Jato(id,
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("velocidade"),
                    rs.getString("cor"));
            DAO.closeConnection();
            return jato;
        }
        DAO.closeConnection();
        return null;
    }

    @Override
    public List<Jato> getAll() throws SQLException {
        List<Jato> jatos = new ArrayList<Jato>();
        ResultSet rs = DAO.createConnection().createStatement().executeQuery(SELECT_JATO);
        while (rs.next()) {
            Jato jato = new Jato(rs.getInt("idJato"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("velocidade"),
                    rs.getString("cor"));
            jatos.add(jato);
        }
        DAO.closeConnection();
        return jatos;
    }

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_JATO);
        stmt.setString(1, marca);
        stmt.setString(2, modelo);
        stmt.setString(3, cor);
        stmt.setInt(4, velocidade);
        stmt.setInt(5, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_JATO);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

}
