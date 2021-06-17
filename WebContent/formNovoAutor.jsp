<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoAutor" var="linkServletNovoAutor"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de Cadastro</title>
</head>
<body>

	<form action="${linkServletNovoAutor }" method="post">
	
		Nome: <input type="text" name="nome"  />
		Email: <input type="text" name="email"  />
		Data de cadastro: <input type="text" name="data"  />
	
		<input type="submit" />
	</form>

</body>
</html>