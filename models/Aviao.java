package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import core.Validator;
import db.DAO;

import static db.SQL.DELETE_AVIAO;
import static db.SQL.INSERT_AVIAO;
import static db.SQL.UPDATE_AVIAO;
import static db.SQL.SELECT_AVIAO;
import static db.SQL.SELECT_AVIAO_ID;

public class Aviao extends Aeronave {
    private String prefixo;
    private int capacidade;
    private Integer idCompanhia;
    private Companhia companhia;

    public Aviao() {
    }

    public Aviao(Integer id,
            String marca,
            String modelo,
            Integer idCompanhia,
            Companhia companhia,
            int capacidade,
            String prefixo) {
        super(id, marca, modelo);
        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;
        this.companhia = companhia;
    }

    public Aviao(String marca,
            String modelo,
            Integer idCompanhia,
            Companhia companhia,
            int capacidade,
            String prefixo) throws Exception {
        super(marca, modelo);

        if (capacidade < 0)
            throw new IllegalArgumentException("Capacidade deve ser maior que 0");

        if (Validator.prefixoAviao().isValid(prefixo))
            throw new IllegalArgumentException("O prefixo do avião deve seguir o padrão de 3 letras e 4 números");

        this.prefixo = prefixo;
        this.capacidade = capacidade;
        this.idCompanhia = idCompanhia;
        this.companhia = companhia;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(INSERT_AVIAO);
        stmt.setNull(1, Types.INTEGER);

        stmt.setString(2, marca);
        stmt.setString(3, modelo);
        stmt.setInt(4,idCompanhia);
        stmt.setInt(5,capacidade);
        stmt.setString(6, prefixo);
        stmt.execute();
        DAO.closeConnection();
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

    public Integer getidCompanhia() {
        return this.idCompanhia;
    }

    public void setidCompanhia(Integer idCompanhia) {
        this.idCompanhia = idCompanhia;
    }

    public Companhia getcompanhia() {
        return this.companhia;
    }

    public void setcompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public void update() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(UPDATE_AVIAO);
        stmt.setString(1, marca);
        stmt.setString(2, modelo);
        stmt.setInt(3, capacidade);
        stmt.setString(4, prefixo);
        stmt.setInt(5, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public void delete() throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(DELETE_AVIAO);
        stmt.setInt(1, id);
        stmt.execute();
        DAO.closeConnection();
    }

    public Aviao getById(Integer id) throws SQLException {
        PreparedStatement stmt = DAO.createConnection().prepareStatement(SELECT_AVIAO_ID);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Aviao aviao = new Aviao(id,
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("idCompanhia"),
                    new Companhia().getById(rs.getInt("idCompanhia")),
                    rs.getInt("capacidade"),
                    rs.getString("prefixo"));
            DAO.closeConnection();
            return aviao;
        }
        DAO.closeConnection();
        return null;
    }

    public List<Aviao> getAll() throws SQLException {
        List<Aviao> avioes = new ArrayList<Aviao>();
        ResultSet rs = DAO.createConnection().createStatement().executeQuery(SELECT_AVIAO);
        while (rs.next()) {
            Aviao aviao = new Aviao(
                    rs.getInt("idAviao"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("idCompanhia"),
                    new Companhia().getById(rs.getInt("idCompanhia")),
                    rs.getInt("capacidade"),
                    rs.getString("prefixo"));
            avioes.add(aviao);
        }
        DAO.closeConnection();
        return avioes;
    }
}
