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

		<h4>Registro de balcao:</h4>

		<form action="/balcao" method="get">
			<button type="submit">Novo Balcao</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty balcaoLista}">
			<p>Quantidade de balcoes registrados: ${balcaoLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						
						<th>Id</th>
						<th>QntdLugares</th>
						<th>CadeiraEspecial</th>
						<th>QualidadeMesa</th>
						<th>BebidaAlcoolica</th>
						<th>ShotsAlcoolicos</th>
						<th>Petisco</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="b" items="${balcaoLista}">
						<tr>
							
							<td>${b.id}</td>
							<td>${b.qntdLugares}</td>
							<td>${b.cadeiraEspecial}</td>
							<td>${b.qualidadeMesa}</td>
							<td>${b.bebidaAlcoolica}</td>
							<td>${b.shotsAlcoolicos}</td>
							<td>${b.petisco}</td>
							<td><a href="/balcao/${b.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						
						<th>Id</th>
						<th>QntdLugares</th>
						<th>CadeiraEspecial</th>
						<th>QualidadeMesa</th>
						<th>BebidaAlcoolica</th>
						<th>ShotsAlcoolicos</th>
						<th>Petisco</th>
						<th></th>
					</tr>
				</tfoot>
			</table>
		</c:if>

		<c:if test="${empty balcaoLista}">
			<p>Não existem balcoes registrados!</p>
		</c:if>
	</div>
</body>
</html>