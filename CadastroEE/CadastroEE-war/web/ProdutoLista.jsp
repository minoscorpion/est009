<%-- 
    Document   : ProdutoLista
    Created on : 2 de nov. de 2024, 11:08:31
    Author     : rafae
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" type="text/css" href="style.css"> <!-- Link para um arquivo CSS, se necessário -->
</head>
<body class="container">
    <h1>Lista de Produtos</h1>
    <a href="ServletProdutoFC?acao=formIncluir" class="btn btn-primary m-2">Incluir Novo Produto</a> <!-- Link para inclusão -->

    <table border="1" class="table table-stripped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}"> <!-- Recupera a lista de produtos -->
                <tr>
                    <td>${produto.produtoID}</td> <!-- Exibe o ID do produto -->
                    <td>${produto.nome}</td> <!-- Exibe o nome do produto -->
                    <td>${produto.quantidade}</td> <!-- Exibe a quantidade -->
                    <td>${produto.precoVenda}</td> <!-- Exibe o preço -->
                    <td>
                        <a href="ServletProdutoFC?acao=formAlterar&id=${produto.produtoID}" class="btn btn-primary btn-sm">Alterar</a> | <!-- Link para alterar -->
                        <a href="ServletProdutoFC?acao=excluir&id=${produto.produtoID}" class="btn btn-danger btn-sm">Excluir</a> <!-- Link para excluir -->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>