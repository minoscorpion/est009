/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.controller.ProdutosFacadeLocal;
import cadastroee.model.Produtos; 
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author rafae
 */
public class ServletProdutoFC extends HttpServlet {

            
    @EJB
    private ProdutosFacadeLocal facade; 
        
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {   
        String acao = request.getParameter("acao"); 
        String destino = ""; 
        
        System.out.println("aki: " + acao);
        
        if ("listar".equals(acao)) {
            List<Produtos> produtos = facade.listarProdutos(); 
            request.setAttribute("produtos", produtos); 
            destino = "ProdutoLista.jsp"; 
            
        } 
        else if ("formIncluir".equals(acao)) 
        {
            destino = "ProdutoDados.jsp"; 
        }
        else if ("formAlterar".equals(acao)) {
            int id = Integer.parseInt(request.getParameter("id")); 
            Produtos produto = facade.buscarProduto(id); 
            request.setAttribute("produto", produto); 
            destino = "ProdutoDados.jsp"; 
        } else if ("excluir".equals(acao)) {
            Integer id = Integer.parseInt(request.getParameter("id")); 
            facade.excluir(id); 
            List<Produtos> produtos = facade.listarProdutos(); 
            request.setAttribute("produtos", produtos); 
            destino = "ProdutoLista.jsp"; 
        } else if ("alterar".equals(acao)) {
            Integer id = Integer.parseInt(request.getParameter("id")); 
            Produtos produto = facade.buscarProduto(id); 
            
            //System.out.println("aki2: " + produto.getProdutoID());
               
            produto.setNome(request.getParameter("nome")); 
            produto.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda"))); 
            produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade"))); 
            produto.setProdutoID(Integer.parseInt(request.getParameter("id"))); 

            facade.alterar(produto); 
            List<Produtos> produtos = facade.listarProdutos(); 
            request.setAttribute("produtos", produtos); 
            destino = "ProdutoLista.jsp"; 
        } else if ("incluir".equals(acao)) {
            Produtos produto = new Produtos(); 
            produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade"))); 
            produto.setPrecoVenda(Float.parseFloat(request.getParameter("precoVenda"))); 
            produto.setNome(request.getParameter("nome")); 
           
            facade.incluir(produto); 
            List<Produtos> produtos = facade.listarProdutos(); 
            request.setAttribute("produtos", produtos); 
            destino = "ProdutoLista.jsp"; 
        }
       
        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); 
    }

    @Override
    public String getServletInfo() {
        return "Servlet para gerenciamento de produtos usando o padrão Front Controller"; // Informação do Servlet
    }
}
