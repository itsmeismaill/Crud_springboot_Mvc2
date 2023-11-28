<%@ page import="java.util.List" %>
<%@ page import="ma.fstt.crudlsi.persistence.Produit" %><%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 22/11/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des produits</title>
</head>
<body>
<% List<Produit> mylist = (List<Produit>)request.getAttribute("mylist"); %>
        <table>
    <th>ID</th>
    <th>Nom</th>
    <th>PU</th>
    <th>Editer</th>
    <th>Supprimer</th>


       <% for(int i = 0 ; i < mylist.size() ; i++){ %>
    <tr>
        <td><%= mylist.get(i).getId_produit()  %></td>
        <td><%= mylist.get(i).getNom()  %></td>
        <td><%= mylist.get(i).getPrixU()  %></td>
        <td ><a href="actionsServlet?action=edit&id=<%= mylist.get(i).getId_produit()  %>">Editer</a></td>
        <td ><a href="actionsServlet?action=delete&id=<%= mylist.get(i).getId_produit()  %>">Supprimer</a></td>


    </tr>
<%}%>

</table>
</body>
</html>
