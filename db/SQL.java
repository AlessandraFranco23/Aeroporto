package db;

public class SQL {
    public static final String SELECT_COMPANHIA = "SELECT * from COMPANHIA";
    public static final String SELECT_COMPANHIA_ID = "SELECT * from COMPANHIA where idCompanhia = ?";
    public static final String INSERT_COMPANHIA = " INSERT INTO COMPANHIA VALUES (?, ? ,?)";
    public static final String DELETE_COMPANHIA = "";
    public static final String UPDATE_COMPANHIA = "";

    public static final String SELECT_HANGAR = "SELECT * from HANGAR";
    public static final String SELECT_HANGAR_ID = "SELECT  * from HANGAR where idHangar = ?";
    public static final String INSERT_HANGAR = "";
    public static final String DELETE_HANGAR = "";
    public static final String UPDATE_HANGAR = "";

    public static final String SELECT_PISTA = "SELECT * from PISTA";
    public static final String SELECT_PISTA_ID = "SELECT  * from PISTA where idPista = ?";
    public static final String INSERT_PISTA = "";
    public static final String DELETE_PISTA = "";
    public static final String UPDATE_PISTA = "";

    public static final String SELECT_AVIAO = "SELECT * from AVIAO";
    public static final String SELECT_AVIAO_ID = "SELECT  * from AVIAO where idAviao = ?";
    public static final String INSERT_AVIAO = "";
    public static final String DELETE_AVIAO = "";
    public static final String UPDATE_AVIAO = "";

    public static final String SELECT_HELICOPTERO = "SELECT * from HELICOPTERO";
    public static final String SELECT_HELICOPTERO_ID = "SELECT  * from HELICOPTERO where idHelicoptero = ?";
    public static final String INSERT_HELICOPTERO = "";
    public static final String DELETE_HELICOPTERO = "";
    public static final String UPDATE_HELICOPTERO = "";

    public static final String SELECT_JATO = "SELECT * from JATO";
    public static final String SELECT_JATO_ID = "SELECT  * from JATO where idJato = ?";
    public static final String INSERT_JATO = "";
    public static final String DELETE_JATO = "";
    public static final String UPDATE_JATO = "";

    public static final String SELECT_VOO = "SELECT * from VOO";
    public static final String SELECT_VOO_ID = "SELECT  * from VOO where idVoo = ?";
    public static final String INSERT_VOO = "";
    public static final String DELETE_VOO = "";
    public static final String UPDATE_VOO = "";
}
