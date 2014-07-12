/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.solutions.pompeu.model.Ingresso;
import com.solutions.pompeu.model.IngressoDAO;
import com.solutions.pompeu.model.UsuarioDAO;
import com.solutions.pompeu.model.Usuario;

/**
 *
 * @author Pompeu
 */
public class TextaConeccao {

    public static void main(String[] args) {
       ingressoUpdate();
    }

    public static void cadUser() {
        Usuario usuario = new Usuario("Pompeu", "552525");
        UsuarioDAO usu = new UsuarioDAO();
        System.out.println(usu.logar(usuario));
    }
    public static void cadIngresso(){
        Ingresso ing = new Ingresso("Camarote Vip",50,"Fanatasy Fest");
        IngressoDAO ingDao = new IngressoDAO();
        ingDao.cadIngressos(ing);
    }
    public static void ingressoUpdate(){
        Ingresso ing =  new Ingresso("Pista", 15, "Fantasy Fest");
        IngressoDAO ingDao = new IngressoDAO();
        ingDao.precoUpdate(ing);
            
    }
}   
