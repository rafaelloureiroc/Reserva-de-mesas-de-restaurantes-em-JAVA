<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
      <div class="container px-4 px-lg-5">
          <button class="navbar-toggler navbar-toggler-right" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
              <ul class="navbar-nav ms-auto my-2 my-lg-0">
              
				  <c:if test="${not empty client}">
                  <li class="nav-item"><a class="nav-link" href="/clientes">Cliente</a></li>
                  <li class="nav-item"><a class="nav-link" href="/solicitantes">Solicitante</a></li>
                  <li class="nav-item"><a class="nav-link" href="/restaurantes">Restaurante</a></li>
                  <li class="nav-item"><a class="nav-link" href="locais">Local</a></li>
                  <li class="nav-item"><a class="nav-link" href="/mesaInternas">MesaInterna</a></li>
                  <li class="nav-item"><a class="nav-link" href="/externas">Externa</a></li>
                  <li class="nav-item"><a class="nav-link" href="/balcoes">Balcao</a></li>
                  
                  </c:if>

  				  <c:if test="${empty client}">
                  <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                  <li class="nav-item"><a class="nav-link" href="/cliente">Signup</a></li>
				  </c:if>

				  <c:if test="${not empty client}">
                  <li class="nav-item"><a class="nav-link" href="/logout">Logout, ${client.nome}</a></li>
                  </c:if>
              </ul>
          </div>
      </div>
  </nav>
