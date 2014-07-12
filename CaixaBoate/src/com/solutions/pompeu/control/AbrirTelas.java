/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.solutions.pompeu.control;

import com.solutions.pompeu.view.Login;
import com.solutions.pompeu.view.Principal;

/**
 *
 * @author Pompeu
 */
public class AbrirTelas {
    /**
     * esse metodo faz abrir a tela principal
     */
    public static void abrirPrincipal(){        
        Principal p =  new Principal();
        p.setVisible(true);
    }
    /**
     * esse metodos faz voltar ao login
     * para mudar de usuario
     */
    public static void abriLogin(){
        Login l = new Login();
        l.setVisible(true);
    }
}
