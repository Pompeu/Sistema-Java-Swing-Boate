/*
 * Copyright 2014 Pompeu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.solutions.pompeu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pompeu
 */
public class Conectar {

    private static final Conectar instace = new Conectar();
    
    private Connection con;
    
    private Conectar() { 
    }

    public static Conectar getInstance() {
        return instace;
    }

    public Connection conect() {
        conexao();
        return con;
    }

    private void conexao() {
        if (con != null) {
            return;
        }
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cartao",
                    "postgres", "1234");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void diconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        con = null;
    }
}
