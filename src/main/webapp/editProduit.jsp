<jsp:useBean id="produit" scope="request" type="ma.fstt.crudlsi.persistence.Produit" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>

<h1>Edit product</h1>
<form action="actionsServlet?action=update" method="post">
  <input type="hidden" name="id" value="${produit.id_produit}"/>
  <label >Nom</label>
  <input type="text" name="nom" value="${produit.nom}"/>
  <br/>
  <label>PrixU</label>
  <input type="number" name="pu" value="${produit.prixU}"/>
  <br/>
  <input type="submit" value="Update"/>
</form>
</body>
<a href="actionsServlet?action=list">Retour à la liste des produits</a>
</html>
