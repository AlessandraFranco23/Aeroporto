package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Search;
import db.DAO;
import db.Database;

import static db.SQL.DELETE_HANGAR;
import static db.SQL.INSERT_HANGAR;
import static db.SQL.UPDATE_HANGAR;
import static db.SQL.SELECT_HANGAR;
import static db.SQL.SELECT_HANGAR_ID;

public class Hangar extends Search implements Database<Hangar> {
    private Integer id;
    private String local;
    private Integer idAviao;
    private Aviao aviao;

    public Hangar(
            Integer id,
            String local,
            Integer idAviao) {
        this.id = id;
        this.local = local;
        this.idAviao = idAviao;
    }

    public Hangar(
            String local,
            Integer idAviao) throws Exception {
        this.local = local;
        this.idAviao = idAviao;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_HANGAR);
        stmt.setString(1, local);
        stmt.setInt(2, idAviao);
        stmt.execute();
        DAO.closeConnection();
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

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Integer getIdAviao() {
        return this.idAviao;
    }

    public void setIdAviao(Integer idAviao) {
        this.idAviao = idAviao;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", local='" + getLocal() + "'" +
            ", idAviao='" + getIdAviao() + "'" +
            "}";
    }

    @Override
    public Hangar getById(Integer id) throws SQLException {
        
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_HANGAR_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Hangar(id, rs.getString("local"), rs.getInt("idAviao"));
        }

        return null;
    }

    @Override
    public List<Hangar> getAll() throws SQLException {
        List<Hangar> hangars = new ArrayList<Hangar>();
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_HANGAR);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Hangar hangar = new Hangar(
                    rs.getInt("idHangar"),
                    rs.getString("local"),
                    rs.getInt("idAviao"));
            hangars.add(hangar);
            DAO.closeConnection();
        }
        return hangars;
    }

    @Override
    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_HANGAR);
        stmt.setString(1, local);
        stmt.setInt(2, idAviao);
        stmt.setInt(3, id);
        stmt.execute();
        DAO.closeConnection();
        
    }

    @Override
    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_HANGAR);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

}