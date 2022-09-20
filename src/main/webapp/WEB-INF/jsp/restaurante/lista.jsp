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
		<form action="/restaurante" method="get">
			<button type="submit">Nova mesa no restaurante</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty restauranteLista}">
			<p>Quantidade de mesas cadastrados no restaurante:
				${restauranteLista.size()}</p>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Descricao</th>
						<th>Data</th>
						<th>Solicitante</th>
						<th>Locais</th>
						
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${restauranteLista}">
						<tr>
							<td>${r.descricao}</td>
							<td>${r.data}</td>
							<td>${r.solicitante.nome}</td>
							<td>${r.locais.size()}</td>
							<td><a href="/restaurante/${r.id}/excluir">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th>Descricao</th>
						<th>Data</th>
						<th>Solicitante</th>
						<th>Locais</th>
						
						<th></th>
					</tr>
				</tfoot>
			</table>
		</c:if>

		<c:if test="${empty restauranteLista}">
			<p>Não existem mesas cadastrados!!!</p>
		</c:if>
	</div>
</body>
</html>

