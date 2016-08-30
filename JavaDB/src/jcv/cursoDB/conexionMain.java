package jcv.cursoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jovanny Colindres
 */
public class conexionMain {

    public static void main(String[] args) throws SQLException {
        conexionMain obj= new conexionMain();
        String nombre="paola", email="paola@gmail.com",pwd="54321";
        obj.registrarDB(nombre,email,pwd);
        
    }
    
    public void registrarDB(String nombre, String email, String pwd) throws SQLException
    {
        //JDBC driver nombre y base de datos URL
        final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
        final String DB_URL="jdbc:mysql://localhost/01curso_php";
        
        //Credenciales de la DB
        final String USER="root";
        final String PASS="";
        Connection conexion= null;
        try {
            Class.forName(JDBC_DRIVER);
            conexion= DriverManager.getConnection(DB_URL, USER, PASS);
            //String query= "INSERT INTO user (nombre, email, password) VALUES('mit', 'jcv@hotmail.com', '123456')";
            
            String query= "INSERT INTO user (nombre, email, password) VALUES(?,?,?)";
            
            PreparedStatement st= conexion.prepareStatement(query);
            st.setString(1, nombre);
            st.setString(2, email);
            st.setString(3, pwd);
            
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
        }finally{
            if(conexion!= null){
                if(!conexion.isClosed()){
                    conexion.close();
                }
            }
        }
    }
}
