/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Produtos;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author rafae
 */
@Stateless
public class ProdutosFacade extends AbstractFacade<Produtos> implements ProdutosFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutosFacade() {
        super(Produtos.class);
    }   
    
      @Override
    public void incluir(Produtos produto) {
        em.persist(produto);
    }

    @Override
    public void alterar(Produtos produto) {
        em.merge(produto);
    }

    @Override
    public void excluir(int id) {
        Produtos produto = em.find(Produtos.class, id);
        if (produto != null) {
            em.remove(produto);
        }
    }

    @Override
    public Produtos buscarProduto(int id) {
        return em.find(Produtos.class, id);
    }
       
    @Override
    public List<Produtos> listarProdutos() {
        return getEntityManager().createQuery("SELECT p FROM Produtos p", Produtos.class).getResultList();
    }
}
