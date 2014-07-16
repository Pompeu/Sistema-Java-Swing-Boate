/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.solutions.pompeu.model.CartaoConsumacao;
import com.solutions.pompeu.model.CartaoConsumacaoDAO;
import com.solutions.pompeu.model.Produto;
import com.solutions.pompeu.model.ProdutoDAO;
import com.solutions.pompeu.model.UsuarioDAO;
import com.solutions.pompeu.model.Usuario;
import java.util.List;

/**
 *
 * @author Pompeu
 */
public class TextaConeccao {

    public static void main(String[] args) {
        prod_ven_atu();
    }
    public static void prod_ven_atu(){
        CartaoConsumacaoDAO cdao = new CartaoConsumacaoDAO();
        //System.out.println(cdao.pegarIdProdutoAtual(1,2));
        cdao.produto_movimento_deletar(1, 2);
    }
    public static void insirNumeroVenda() {
        CartaoConsumacaoDAO cdao = new CartaoConsumacaoDAO();

        Long a = cdao.inserirIdVenda();
        System.out.println(a);

    }

    public static void cadUser() {
        Usuario usuario = new Usuario("Pompeu", "552525");
        UsuarioDAO usu = new UsuarioDAO();
        System.out.println(usu.logar(usuario));
    }

    public static void cadCartao() {
        CartaoConsumacao cartao = new CartaoConsumacao(35, 25, 6);
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.cartaoStart(cartao);
    }

    public static void mostraSaldoCartao() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        System.out.println(cartaoDAO.cartaoSAldo(15));
    }

    public static void updateCartao(double creditos, long num, long usuNum) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        System.out.println("Antes :" + cartaoDAO.cartaoSAldo(num));
        CartaoConsumacao cartao = new CartaoConsumacao(cartaoDAO.cartaoSAldo(num) + creditos, num, usuNum);
        cartaoDAO.cartaoUpdate(cartao);
        System.out.println("Depois :" + cartaoDAO.cartaoSAldo(num));
    }

    public static void vendas(double saldo, long num, long usuNum) {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        cartaoDAO.vendas(saldo, num, usuNum);
    }

    public static void cadProd() {
        Produto p = new Produto("suco", 10.00);
        ProdutoDAO pd = new ProdutoDAO();
        pd.cadProduto(p);
    }

    public static void exProd() {
        Produto p = new Produto(9);
        ProdutoDAO pd = new ProdutoDAO();
        pd.excluirProdutos(p);
    }

    public static void buscaProdID() {

        ProdutoDAO pd = new ProdutoDAO();
        System.out.println(pd.buscarProdutoId(14).getPreco());
        ProdutoDAO pd2 = new ProdutoDAO();
        System.out.println(pd2.buscarProdutoId(14).getNome());
    }

    public static void listProd() {
        ProdutoDAO pd = new ProdutoDAO();
        List<Produto> listaProduto = pd.buscarProdutos();
        for (Produto p : listaProduto) {
            System.out.println(p.getProduto_id() + " " + p.getNome() + " " + p.getPreco());
        }
    }

    public static void listaCartaoUsu() {
        CartaoConsumacaoDAO cDao = new CartaoConsumacaoDAO();
        Usuario nome = cDao.listaCartao(15);
        System.out.println(nome);
    }

    public static Long pegarNovoIdVenda() {

        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();

        System.out.println(cartaoDAO.pegarNovoIdVenda());
        return cartaoDAO.pegarNovoIdVenda();

    }
}
