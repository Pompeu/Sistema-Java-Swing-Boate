/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.solutions.pompeu.jdbc.UsuarioDao;
import com.solutions.pompeu.model.Usuario;

/**
 *
 * @author Pompeu
 */
public class TextaConeccao {

    public static void main(String[] args) {
             
        Usuario usuario = new Usuario("Pompeu", "552525");
        UsuarioDao usu = new UsuarioDao();
        System.out.println(usu.logar(usuario));
    }
}
