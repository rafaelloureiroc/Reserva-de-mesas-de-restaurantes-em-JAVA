<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8" />
	<title>ProjetoJava</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>

	<header class="masthead">
    <div class="container px-4 px-lg-5 h-100">
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	</div>
	</header>

	<div class="container">
	
		<form action="/solicitante/incluir" method="post">
			<h2>Cadastramento de Solicitantes</h2>
		
			<div class="form-group">
				<label>Nome:</label>
				<input type="text" class="form-control" name="nome" value="manuela joaquina"> 
			</div>
			
			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" class="form-control" name="email" value="manu.joaquina@infnet.edu.br">
			</div>
			
			<div class="form-group">
				<label>CPF:</label>
				<input type="text" class="form-control" name="cpf" value="123456789-01"> 
			</div>

			<button type="submit">Cadastrar</button>
		</form>		
	</div>
</body>
</html>