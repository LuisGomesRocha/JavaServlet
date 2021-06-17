<%
 //scriplet
 String nomeAutor = (String)request.getAttribute("autor");
 System.out.println(nomeAutor);
%>


<html><body>
Autor <%= nomeAutor  %> cadastrado(a) com sucesso!
</body></html>