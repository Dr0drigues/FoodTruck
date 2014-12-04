<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="include/header.jsp" />
<title>Boissons</title>
</head>
<body>
	<h2>Liste des boissons</h2>
	<div align="right">
		<a href="${pageContext.request.contextPath}/article/adddrink"
			class="btn btn-default" id="add">Ajouter un article</a>

	</div>
	<table class="table-striped table-hover" id="tableDrink" width="100%">
		<thead>
			<tr align="center">
				<th>Numéro</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Volume</th>
				<th>Type</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="drink" items="${listdrink}">
				<tr align="center">
					<td>${drink.id}</td>
					<td>${drink.name}</td>
					<td>${drink.price}</td>
					<td>${drink.volume}</td>
					<td>${drink.type}</td>
					<td><a
						href="${pageContext.request.contextPath}/article/delete/${drink.id}"
						class="btn btn-danger btn-sm delete"> - </a></td>
				</tr>				
			</c:forEach>
		</tbody>
	</table>


	<%-- <c:choose>
	<c:when test="${mode=='ajout'}">
		<c:set var="actionformulaire" scope="request"
			value="${pageContext.request.contextPath}/article/add" />
		<c:set var="libelleBox" scope="request" value="Ajout de article" />
		<c:set var="libellebouton" scope="request" value="Ajouter" />
	</c:when>
	<c:when test="${mode=='edition'}">
		<c:set var="actionformulaire" scope="request"
			value="${pageContext.request.contextPath}/article/edit" />
		<c:set var="libelleBox" scope="request" value="Edition de article" />
		<c:set var="libellebouton" scope="request" value="Editer" />
	</c:when>
	<c:when test="${mode=='suppression'}">
		<c:set var="actionformulaire" scope="request"
			value="${pageContext.request.contextPath}/article/delete" />
		<c:set var="libelleBox" scope="request" value="Suppression de article" />
		<c:set var="libellebouton" scope="request" value="Supprimer" />
	</c:when>
</c:choose>
 --%>

	<c:set var="actionformulaire" scope="request"
		value="${pageContext.request.contextPath}/article/adddrink" />
	<c:set var="libelleBox" scope="request" value="Ajout de boisson" />
	<c:set var="libellebouton" scope="request" value="Ajouter" />

	<div id="dialog-drink" title="libelleBox" style="display: none">

		<form:form role="form" action="${actionformulaire}" method="POST"
			commandName="drink">
<%-- 			<form:hidden path="id" /> --%>

			<div class="form-group">
				<form:label path="name">Nom</form:label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="description">Description</form:label>
				<form:input path="description" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="price">Prix</form:label>
				<form:input path="price" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="volume">Volume</form:label>
				<form:select path="volume" class="form-control">
					<form:options items="${listVolumeDrink}" />
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="type">Type</form:label>
				<form:select path="type" class="form-control">
					<form:options items="${listTypeDrink}" />
				</form:select>
			</div>
			<div id="error" style="display:none">Une erreur s'est produite</div>

<%-- 			<input type="submit" class="btn btn-default" value="${libellebouton}"> --%>
		</form:form>
	</div>

	<jsp:include page="include/footer.jsp" />