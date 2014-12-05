<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Affichage des clients</title>
<jsp:include page="include/header.jsp" />
</head>

<body>
	
	<!-- <jsp:include page="include/menu.jsp"></jsp:include> -->
	
	<!-- For Each en JSTL -->
	<table class="table table-striped table-hover" id="tableClient dataTable no-footer">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>E-mail</th>
				<th></th>
			</tr>
		</thead>
		<c:forEach var="client" items="${clientlist}">
			<tr>
				<td>ID : ${client.id}</td>
				<td>Nom : ${client.lastName}</td>
				<td>Prénom : ${client.firstName}</td>
				<td>E-mail : ${client.mail}</td>
				<td><a
					href="${pageContext.request.contextPath}/Command/${client.id}"
					class="btn btn-default btn-sm" id="btncmd"> Commande </a> <a
					href="${pageContext.request.contextPath}/client/update/${client.id}"
					class="btn btn-primary btn-sm" id="btnedit"> Editer </a> <a
					href="${pageContext.request.contextPath}/client/delete/${client.id}"
					class="btn btn-danger btn-sm" id="btndelete"> Supprimer </a>
			</tr>
		</c:forEach>

	</table>


	<a href="${pageContext.request.contextPath}/client/addclient"
		class="btn btn-success btn-sm" id="btnadd"> Ajouter un client </a>

	<div id="dialog-delete" title="Suppression client"
		style="display: none">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"> </span> Etes vous sur de
			vouloir supprimer ce client ?
		</p>
	</div>

	<div id="dialog-client" title="Ajout client" style="display: none">
		<h2 class="col-md-12">Ajout client</h2>
		
		<form:form role="form"
			action="${pageContext.request.contextPath}/client/addclient"
			method="POST" commandName="addclient">
			<!-- <form:hidden path="id" /> -->

			<div class="form-group">
				<form:label path="lastName">Nom</form:label>
				<form:input path="lastName" class="form-control" />
			</div>

			<div class="form-group">
				<form:label path="firstName">Prénom</form:label>
				<form:input path="firstName" class="form-control" />
			</div>

			<div class="form-group">
				<form:label path="mail">E-mail</form:label>
				<form:input path="mail" class="form-control" />
			</div>

			<div class="form-group">
				<form:label path="password">mot de passe</form:label>
				<form:input path="password" class="form-control" />
			</div>

		</form:form>
	</div>


</body>
<footer>
	<jsp:include page="include/footer.jsp" />
</footer>
</html>
