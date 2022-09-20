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
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container fixed-top" >	

		<h4>Registro de MesasInternas:</h4>

		<form action="/mesaInterna" method="get">
			<button type="submit">Nova MesaInterna</button>
		</form>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
			  <strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<c:if test="${not empty mesaInternaLista}">
		  	<p>Quantidade de mesas Internas registradas: ${mesaInternaLista.size()}</p>            
		  	<table class="table table-striped">
			    <thead>
			      <tr>
			       <th>Id</th>
			        <th>QntdLugares</th>
			        <th>CadeiraEspecial</th>
			        <th>QualidadeMesa</th>
			        <th>ArCondicionado</th>
			        <th>VelaRomantica</th>
			        <th>IluminacaoEspecial</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="m" items="${mesaInternaLista}">
			      <tr>
			        <td>${m.id}</td>
			        <td>${m.qntdLugares}</td>
			        <td>${m.cadeiraEspecial}</td>
			        <td>${m.qualidadeMesa}</td>
			        <td>${m.arCondicionado}</td>
			        <td>${m.velaRomantica}</td>
			        <td>${m.iluminacaoEspecial}</td>
			        <td><a href="/mesaInterna/${m.id}/excluir">Excluir</a></td>
			      </tr>
				</c:forEach>
			    </tbody>
			    <tfoot>
			      <tr>
			        <th>Id</th>
			        <th>QntdLugares</th>
			        <th>CadeiraEspecial</th>
			        <th>QualidadeMesa</th>
			        <th>ArCondicionado</th>
			        <th>VelaRomantica</th>
			        <th>IluminacaoEspecial</th>
			        <th></th>
			      </tr>
			    </tfoot>
		  	</table>
		</c:if>
		
		<c:if test="${empty mesaInternaLista}">
	  		<p>Não existem mesas Internas cadastradas</p>            
	  	</c:if>
	</div>
</body>
</html>