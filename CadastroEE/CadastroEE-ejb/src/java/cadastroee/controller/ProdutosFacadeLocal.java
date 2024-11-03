/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Produtos;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author rafae
 */
@Local
public interface ProdutosFacadeLocal {

    void incluir(Produtos produtos);

    void alterar(Produtos produtos);

    void excluir(int id);

    List<Produtos> listarProdutos();
    
    Produtos buscarProduto(int id);

    int count();
    
}
