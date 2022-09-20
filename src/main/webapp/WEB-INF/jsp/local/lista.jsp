<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ProjetoJava</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container fixed-top">

		<h4>Cadastramento dos locais:</h4>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty localLista}">
			<p>Quantidade de locais registrados: ${localLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Tipo</th>
						<th>Id</th>
						<th>QntdLugares</th>
						<th>CadeiraEspecial</th>
						<th>QualidadeMesa</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${localLista}">
						<tr>
							<td>${l.tipo}</td>
							<td>${l.id}</td>
							<td>${l.qntdLugares}</td>
							<td>${l.cadeiraEspecial}</td>
							<td>${l.qualidadeMesa}</td>
							<td><a href="/local/${l.id}/excluir">Excluir</a></td>

						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Tipo</th>
						<th>Id</th>
						<th>QntdLugares</th>
						<th>CadeiraEspecial</th>
						<th>QualidadeMesa</th>
						<th></th>
					</tr>
				</tfoot>
			</table>
		</c:if>

		<c:if test="${empty localLista}">
			<p>Não existem locais registrados</p>
		</c:if>
	</div>
</body>
</html>