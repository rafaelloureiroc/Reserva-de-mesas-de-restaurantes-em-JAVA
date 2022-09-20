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

	<header class="masthead">
		<div class="container px-4 px-lg-5 h-100">
			<c:import url="/WEB-INF/jsp/menu.jsp" />
		</div>
	</header>

	<div class="container">

		<form action="/restaurante/incluir" method="post">
			<h2>Cadastramento de mesas no restaurante</h2>
		
			<div class="form-group">
				<label>descricao:</label>
				<input type="text" class="form-control" name="descricao" value="Primeiro pedido"> 
			</div>

			<div class="form-group">
				<label>Solicitante:</label>
				<select name="solicitante.id" class="form-control">
					<c:forEach var="s" items="${solicitanteLista}">
						<option value="${s.id}">${s.nome}</option>
					</c:forEach>
				</select>
			</div>

			<div class="form-group">
				<label>Locais e Quantidade de Lugares:</label>
				
				<c:forEach var="l" items="${localLista}">
					<div class="checkbox">
					  <label><input type="checkbox" name="idsLocais" value="${l.id}" checked> ${l.tipo}</label> ${l.qntdLugares}</label>
					</div>
				</c:forEach>	
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>
