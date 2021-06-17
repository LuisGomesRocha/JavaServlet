<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,br.com.zup.editora.servlet.Autor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de Autores</title>
</head>
<body>

	<c:if test="${not empty autor}">
		Autor ${ autor } cadastrada com sucesso!
	</c:if>
	
	Lista de autores: <br />
	
	<ul>
		<c:forEach items="${autores}" var="autor">
			
			<li>
				${autor.nome } - <fmt:formatDate value="${autor.dataAbertura }" pattern="dd/MM/yyyy"/> 
				
				<a href="/editora/mostraAutor?id=${autor.id }">edita</a>
				<a href="/editora/removeAutor?id=${autor.id }">remove</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>



