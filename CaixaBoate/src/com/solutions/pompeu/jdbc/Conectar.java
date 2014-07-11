/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutions.pompeu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class Conectar {

    public static Connection conect() {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/caixa", "postgres",
                    "1234");
            //JOptionPane.showMessageDialog(null, "Online");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return con;
    }

}
