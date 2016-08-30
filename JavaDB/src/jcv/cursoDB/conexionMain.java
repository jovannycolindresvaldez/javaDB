package jcv.cursoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jcv.model.User;

/**
 *
 * @author Jovanny Colindres
 */
public class conexionMain {

    public static void main(String[] args) throws SQLException {
        conexionMain obj = new conexionMain();
        String nombre = "paola", email = "paola@gmail.com", pwd = "54321";
        //obj.registrarDB(nombre, email, pwd);
        List<User> listaU=obj.listar();
        System.out.println("");
    }

    public void registrarDB(String nombre, String email, String pwd) throws SQLException {
        //JDBC driver nombre y base de datos URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/01curso_php";

        //Credenciales de la DB
        final String USER = "root";
        final String PASS = "";
        Connection conexion = null;
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            //String query= "INSERT INTO user (nombre, email, password) VALUES('mit', 'jcv@hotmail.com', '123456')";

            String query = "INSERT INTO user (nombre, email, password) VALUES(?,?,?)";

            PreparedStatement st = conexion.prepareStatement(query);
            st.setString(1, nombre);
            st.setString(2, email);
            st.setString(3, pwd);

            st.executeUpdate();
            st.close();
            
        } catch (Exception e) {
        } finally {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        }
    }

    public List<User> listar() throws SQLException {
        //JDBC driver nombre y base de datos URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/01curso_php";

        //Credenciales de la DB
        final String USER = "root";
        final String PASS = "";
        Connection conexion = null;
        List<User> lista= new ArrayList();
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            //String query= "INSERT INTO user (nombre, email, password) VALUES('mit', 'jcv@hotmail.com', '123456')";

            String query = "SELECT * FROM user";

            PreparedStatement st = conexion.prepareStatement(query);

            ResultSet rs= st.executeQuery();
            
            while(rs.next()){
                User user= new User();
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setEmail(rs.getString("email"));
                user.setPwd(rs.getString("password"));
                lista.add(user);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        } finally {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        }
        return lista;
    }
}
