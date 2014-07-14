/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.solutions.pompeu.model.CartaoConsumacao;
import com.solutions.pompeu.model.CartaoConsumacaoDAO;
import com.solutions.pompeu.model.Ingresso;
import com.solutions.pompeu.model.IngressoDAO;
import com.solutions.pompeu.model.Produto;
import com.solutions.pompeu.model.ProdutoDAO;
import com.solutions.pompeu.model.UsuarioDAO;
import com.solutions.pompeu.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pompeu
 */
public class TextaConeccao {

    public static void main(String[] args) {
     listProd();
    }

    public static void cadUser() {
        Usuario usuario = new Usuario("Pompeu", "552525");
        UsuarioDAO usu = new UsuarioDAO();
        System.out.println(usu.logar(usuario));
    }

    public static void cadIngresso() {
        Ingresso ing = new Ingresso("Camarote Vip", 50, "Fanatasy Fest");
        IngressoDAO ingDao = new IngressoDAO();
        ingDao.cadIngressos(ing);
    }

    public static void ingressoUpdate() {
        Ingresso ing = new Ingresso("Pista", 15, "Fantasy Fest");
        IngressoDAO ingDao = new IngressoDAO();
        ingDao.precoUpdate(ing);

    }

    public static void cadCartao() {
        CartaoConsumacao cartao = new CartaoConsumacao(35, 25);
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.cartaoStart(cartao);
    }

    public static void mostraSaldoCartao() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        System.out.println(cartaoDAO.cartaoSAldo(15));
    }

    public static void updateCartao() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        System.out.println("Antes :" + cartaoDAO.cartaoSAldo(15));
        CartaoConsumacao cartao = new CartaoConsumacao((float) cartaoDAO.cartaoSAldo(15)+300, 15);
        cartaoDAO.cartaoUpdate(cartao);
        System.out.println("Depois :" + cartaoDAO.cartaoSAldo(15));
    }
    
    public static void cadProd(){
        Produto p = new Produto("suco",10.00 );
        ProdutoDAO pd = new ProdutoDAO();
        pd.cadProduto(p);
    }
    
    public static void exProd(){
        Produto p = new Produto(9);
        ProdutoDAO pd = new ProdutoDAO();
        pd.excluirProdutos(p);
    }
    
    public static void listProd(){
        ProdutoDAO pd = new ProdutoDAO();
        List<Produto> listaProduto = pd.buscarProdutos();        
        for (Produto p : listaProduto) {
            System.out.println(p.getId()+" "+p.getNome()+" "+p.getPreco());
        }
    }
}
