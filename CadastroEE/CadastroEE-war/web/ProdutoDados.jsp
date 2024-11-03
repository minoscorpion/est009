<%-- 
    Document   : ProdutoDados
    Created on : 3 de nov. de 2024, 14:09:55
    Author     : rafae
--%>

<%@page import="cadastroee.model.Produtos"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Cadastro de Produto</title>
    <link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<body class="container">
    <h1>${acao == 'incluir' ? 'Incluir Produto' : 'Alterar Produto'}</h1>

    <form action="ServletProdutoFC" method="post" class="form">
        <input type="hidden" name="acao" value="<%= (request.getAttribute("produto") == null) ? "incluir" : "alterar" %>"/>
        <input type="hidden" name="id" value="<%= (request.getAttribute("produto") != null) ? ((Produtos) request.getAttribute("produto")).getProdutoID(): "" %>"/>
        
        <div class="mb-3">
            <label class="label">Nome:</label>
            <input type="text" class="form-control" name="nome" value="<%= (request.getAttribute("produto") != null) ? ((Produtos) request.getAttribute("produto")).getNome() : "" %>"/>
        </div>
        <div class="mb-3">
            <label class="label">Quantidade:</label>
            <input type="number" class="form-control" name="quantidade" value="<%= (request.getAttribute("produto") != null) ? ((Produtos) request.getAttribute("produto")).getQuantidade() : "" %>"/>
        </div>
        <div class="mb-3">
            <label class="label">Preço de Venda</label>
            <input type="text" class="form-control" name="precoVenda" value="<%= (request.getAttribute("produto") != null) ? ((Produtos) request.getAttribute("produto")).getPrecoVenda(): "" %>"/>
        </div>
        
        <input type="submit" class="btn btn-primary" value="<%= (request.getAttribute("produto") == null) ? "incluir" : "alterar" %>"/>
    </form>

    <a href="ServletProdutoFC?acao=listar">Voltar à Lista de Produtos</a> 
</body>
</html>
