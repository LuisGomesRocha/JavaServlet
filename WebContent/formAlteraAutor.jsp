<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/alteraAutor" var="linkServletNovoAutor"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de Edição</title>
</head>
<body>

	<form action="${linkServletNovoAutor }" method="post">
	
		Nome: <input type="text" name="nome" value="${autor.nome }" />
		Email: <input type="text" name="email" value="${email.nome }" />
		Data de Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${autor.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${autor.id }">
		<input type="submit" />
	</form>

</body>
</html>