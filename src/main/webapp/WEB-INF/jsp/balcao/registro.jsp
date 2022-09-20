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

		<form action="/balcao/incluir" method="post">
			<h2>Registro de balcao</h2>



			<div class="form-group">
				<label>QntdLugares:</label> <input type="text" class="form-control"
					name="qntdLugares" value="2">
			</div>

			<div class="form-group">
				<label>CadeiraEspecial:</label> <input type="text"
					class="form-control" name="cadeiraEspecial" value="true">
			</div>
			<div class="form-group">
				<label>QualidadeMesa:</label> <input type="text"
					class="form-control" name="qualidadeMesa" value="madeira">
			</div>




			<div class="form-group">
				<label>Designações: </label>
				
				
				<div class="form-group">
					<label>ShotsAlcoolicos:</label> <input type="text"
						class="form-control" name="shotsAlcoolicos" value="4">
				</div>
				<div class="form-group">
					<label>Petisco:</label> <input type="text"
						class="form-control" name="petisco" value="batata">
				</div>

				

				<div class="form-group">
					<label>BebidaAlcoolica:</label> <input type="text"
						class="form-control" name="bebidaAlcoolica" value="vodka">
				</div>
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>