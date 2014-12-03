<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage des clients</title>
<jsp:include page="include/header.jsp"/>
</head>

<body>
<!-- For Each en JSTL -->
<table class="table table-striped table-hover">
<c:forEach var="client" items="${list}">
  <tr>
  	<td> ID : ${client.id}</td>
    <td> Nom : ${client.lastName}</td>
    <td> Prénom : ${client.firstName}</td>
    <td> E-mail : ${client.mail}</td>
    <td>
    	<a href="${pageContext.request.contextPath}/Command/${client.id}" class="btn btn-default btn-sm">
    		Commande
    	</a>
    	<a href="${pageContext.request.contextPath}/clientList/clientUpdate/${client.id}" class="btn btn-primary btn-sm">
    		Editer
    	</a>
    	<a href="${pageContext.request.contextPath}/ListeClients/delete/${client.id}" class="btn btn-danger btn-sm confirmModal" >
    		Supprimer
    	</a>
  </tr>
</c:forEach>
</table>


<a href="${pageContext.request.contextPath}/clientList/addClient" class="btn btn-success btn-sm">
    		Ajout client
    	</a>

</body>
<footer>
<jsp:include page="include/footer.jsp"/>
</footer>
</html> 