package jcv.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jovanny Colindres
 */
public class Conexion {

    protected Connection conexion;
    //JDBC driver nombre y base de datos URL
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/01curso_php";

    //Credenciales de la DB
    final String USER = "root";
    final String PASS = "";

    public void conectar() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception e) {
        }
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
            }
        }
    }
}
