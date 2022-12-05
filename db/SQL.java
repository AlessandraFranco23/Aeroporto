package db;

public class SQL {
    public static final String SELECT_COMPANHIA = "SELECT * from COMPANHIA";
    public static final String SELECT_COMPANHIA_ID = "SELECT * from COMPANHIA where idCompanhia = ?";
    public static final String INSERT_COMPANHIA = " INSERT INTO COMPANHIA VALUES (?, ? , ?)";
    public static final String DELETE_COMPANHIA = "UPDATE COMPANHIA SET nome = ? WHERE id= ?";
    public static final String UPDATE_COMPANHIA = "DELETE FROM COMPANHIA WHERE id = ?";

    public static final String SELECT_HANGAR = "SELECT * from HANGAR";
    public static final String SELECT_HANGAR_ID = "SELECT  * from HANGAR where idHangar = ?";
    public static final String INSERT_HANGAR = "INSERT INTO HANGAR VALUES (?, ? , ?)";
    public static final String DELETE_HANGAR = "UPDATE HANGAR SET nome = ? WHERE id= ? ";
    public static final String UPDATE_HANGAR = "DELETE FROM HANGAR WHERE id = ?";

    public static final String SELECT_PISTA = "SELECT * from PISTA";
    public static final String SELECT_PISTA_ID = "SELECT  * from PISTA where idPista = ?";
    public static final String INSERT_PISTA = "INSERT INTO PISTA VALUES (?, ?)";
    public static final String DELETE_PISTA = "UPDATE PISTA SET nome = ? WHERE id= ? ";
    public static final String UPDATE_PISTA = "DELETE FROM PISTA WHERE id = ?";

    public static final String SELECT_AVIAO = "SELECT * from AVIAO";
    public static final String SELECT_AVIAO_ID = "SELECT  * from AVIAO where idAviao = ?";
    public static final String INSERT_AVIAO = "INSERT INTO AVIAO VALUES (?, ? , ?, ?, ? ,?)";
    public static final String DELETE_AVIAO = "UPDATE AVIAO SET nome = ? WHERE id= ?";
    public static final String UPDATE_AVIAO = "DELETE FROM AVIAO WHERE id = ?";

    public static final String SELECT_HELICOPTERO = "SELECT * from HELICOPTERO";
    public static final String SELECT_HELICOPTERO_ID = "SELECT  * from HELICOPTERO where idHelicoptero = ?";
    public static final String INSERT_HELICOPTERO = "INSERT INTO HELICOPTERO VALUES (?, ? , ?, ?, ? ,?)";
    public static final String DELETE_HELICOPTERO = "UPDATE HELICOPTERO SET nome = ? WHERE id= ?";
    public static final String UPDATE_HELICOPTERO = "DELETE FROM HELICOPTERO WHERE id = ?";

    public static final String SELECT_JATO = "SELECT * from JATO";
    public static final String SELECT_JATO_ID = "SELECT  * from JATO where idJato = ?";
    public static final String INSERT_JATO = "INSERT INTO JATO VALUES (?, ? , ?, ?, ?)";
    public static final String DELETE_JATO = "UPDATE JATO SET nome = ? WHERE id= ?";
    public static final String UPDATE_JATO = "DELETE FROM JATO WHERE id = ?";

    public static final String SELECT_VOO = "SELECT * from VOO";
    public static final String SELECT_VOO_ID = "SELECT  * from VOO where idVoo = ?";
    public static final String INSERT_VOO = "INSERT INTO VOO VALUES (?, ? , ?, ?, ? ,?, ?, ? , ?, ?, ? ,?, ?)";
    public static final String DELETE_VOO = "UPDATE VOO SET nome = ? WHERE id= ?";
    public static final String UPDATE_VOO = "DELETE FROM VOO WHERE id = ?";
}
