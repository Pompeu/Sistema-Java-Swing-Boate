/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import com.solutions.pompeu.control.CartaoConsumacaoCrudControl;
import com.solutions.pompeu.control.ProdutosControl;
import com.solutions.pompeu.model.CartaoConsumacaoDAO;
import com.solutions.pompeu.model.Produto;
import com.solutions.pompeu.model.ProdutoDAO;
import com.solutions.pompeu.model.Usuario;
import java.util.List;

/**
 *
 * @author Pompeu
 */
public class TextaConeccao {

    public static void main(String[] args) {
        ProdutosControl pdo = new ProdutosControl();
        List<Produto> lista = pdo.listaProdutos();
        for (Produto lista1 : lista) {
            System.err.println(lista1.getNome()+" "+lista1.getPreco());
        }
        
        
    }

    public static void cadCartao() {
        CartaoConsumacaoCrudControl cartao = new CartaoConsumacaoCrudControl();
        cartao.cadastraCartao(3, "Pompeu", 999.00);
    }

    public static void mostraSaldoCartao() {
        CartaoConsumacaoDAO cartaoDAO = new CartaoConsumacaoDAO();
        System.out.println(cartaoDAO.cartaoSAldo(15));
    }

    public static void updateCartao(long id, double saldo) {
        CartaoConsumacaoCrudControl cartao = new CartaoConsumacaoCrudControl();
        cartao.atulizarCartao(id, saldo);
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
