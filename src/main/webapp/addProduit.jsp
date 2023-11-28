<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 22/11/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add produit </title>
</head>
<body>

<form action="actionsServlet?action=save" method="post">

    <input type="hidden"  name="id"  value="">
    <label>Nom </label>
    <input type="text" name="nom" value=""><br/>

    <label>PU </label>
    <input type="number" name="pu"  value=""><br/>

    <input type="submit"  value="save">


</form>

</body>
</html>
