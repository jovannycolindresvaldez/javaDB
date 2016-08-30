/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcv.cursoDB;

import jcv.DAO.DAOUser;
import jcv.model.User;

/**
 *
 * @author Jovanny Colindres
 */
public class MainDAO {
    public static void main(String[] args) {
        User use= new User();
        //use.setId(22);
        use.setNombre("Gaby");
        use.setEmail("gab@gmail.com");
        use.setPwd("gmail");
        
        try {
            DAOUser dao= new DAOUser();
            dao.registrar(use);
        } catch (Exception e) {
        }
    }
}
