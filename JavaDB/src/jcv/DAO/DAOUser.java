/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcv.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jcv.model.User;

/**
 *
 * @author Jovanny Colindres
 */
public class DAOUser extends Conexion implements jcv.interfaces.DAOUser{

    @Override
    public void registrar(User user) throws Exception {
        try {
            String query = "INSERT INTO user (nombre, email, password) VALUES(?,?,?)";
            this.conectar();
            PreparedStatement st=this.conexion.prepareStatement(query);
            st.setString(1, user.getNombre());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPwd());
            st.executeUpdate();
        } catch (Exception e) {
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void modificar(User user) throws Exception {
        try {
            String query = "UPDATE user set nombre=? where id=?";
            this.conectar();
            PreparedStatement st=this.conexion.prepareStatement(query);
            st.setString(1, user.getNombre());
            st.setInt(2, user.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
        }finally{
            this.cerrar();
        }
    }

    @Override
    public void eliminar(User user) throws Exception {
        try {
            String query = "DELEATE FROM user where id=?";
            this.conectar();
            PreparedStatement st=this.conexion.prepareStatement(query);
            st.setInt(1, user.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<User> listar() throws Exception {
        List<User> lista= new ArrayList();
        try {
            
            String query = "SELECT * FROM user";
            this.conectar();
            PreparedStatement st=this.conexion.prepareStatement(query);
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
        }finally{
            this.cerrar();
        } return lista;
    }

}
