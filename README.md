<h1 align="center">
    <a href="https://cursos.alura.com.br/course/servlets-fundamentos-programacao-web-java">🔗 JavaServlet </a>
</h1>

<p align="center">🚀 Formulário de proposta de solução - Java Servlet: Fundamentos da programação Web Java 🚀 </p>

<h4 align="center"> 
	🚧  Servlet  🚀 Em construção...  🚧
</h4>

<p align="justify">🚀
Mais na frente, aqui no treinamento, você vai trabalhar num projeto que simula uma editora de livros. Neste projeto vai ser necessário que você cadastre numa lista em memória um novo autor(a). Cada autor(a) tem um nome e um email. Imagine que você precisa fazer isso usando o conhecimento que você adquiriu no curso de servlets. Descreva aqui como seria a solução e o motivo associado a cada passo. 

Para te ajudar: Qual classe você criaria? De quem ela herdaria? Qual método você vai sobrescrever? Vai usar um get ou um post para receber os dados? Qual redirecionamento vai utilizar? E claro que você deve acrescentar todo o resto para completar a funcionalidade.
  
 🚀 </p>

### Features

- [x] Novo autor(a)
- - [X] Cada autor(a) tem um nome e um email
- [x] Qual classe você criaria?
- [x] De quem ela herdaria?
- [x] Qual método você vai sobrescrever?
- [X] Vai usar um get ou um post para receber os dados?
- [X] Qual redirecionamento vai utilizar?


<p align="justify"> :robot: Vamos inicialmente criar a classe que foi requisidada intitulada "Autor", que possou os atributos que foram pedidos como nome, e-mail e em conjunto um Id. Em seguida vamos criar uma classe denominada Banco responsável por salvar em memórias as informações sobre os autores que vamos fornecer. :robot: </p>

Dentro da classe Banco teremos os seguintes métodos:
•	Uma metodo que cadastra novos autores;
•	Uma metodo que edita autores;
•	Uma metodo que exclui autores;
•	Uma metodo que lista os autores cadastrados.


<p align="center">  <img src="https://thumbs.gfycat.com/EarnestPracticalArabianoryx-max-1mb.gif" width="250" height="200" /> </p>

```
#Autor Class:

package br.com.zup.editora.servlet;
import java.util.Date;

public class Autor {

	private Integer id;
	private String nome;
	private String email;
	private Date dataAbertura = new Date();
	
	Getter and Setter
  
  .
  .
  .
  
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}	
}


```

<p align="center">  <img src="https://www.thrust.com.br/img/integration.gif" width="150" height="150" /> </p>


```
#Banco Class:

package br.com.zup.editora.servlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Banco {
	
	private static List<Autor> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Autor autor = new Autor();
		autor.setId(chaveSequencial++);
		autor.setNome("Rui Castro");
		autor.setEmail("ruicasto@gmail.com");
		
		Autor autor2 = new Autor();
		autor2.setId(chaveSequencial++);
		autor2.setNome("Biri Flowers");
		autor.setEmail("pipnarigudo@gmail.com");
		
		lista.add(autor);
		lista.add(autor2);
	}

	public void adiciona(Autor autor) {
		autor.setId(Banco.chaveSequencial++);
		Banco.lista.add(autor);
	}
	

	public List<Autor> getAutores(){
		return Banco.lista;
	}
	
	public void removeAutor(Integer id) {
		
		Iterator<Autor> it = lista.iterator();
		
		while(it.hasNext()) {
			Autor aut = it.next();
			
			if(aut.getId() == id) {
				it.remove();
			}
		}
	}

	public Autor buscaAutorPeloId(Integer id) {
		for (Autor autor : lista) {
			if(autor.getId() == id) {
				return autor;
			}
		}
		return null;
	}

}
    
```


<p align="justify"> :robot: Vamos iniciar criando um projeto Dynamic Web Project. Os envios de dados serão feitos através do método POST (a fim anexar os dados no corpo da mensagem). Utilizaremos Servelet´s para realizar as interações entre as classes supracitadas uma vez que Servlet (servidorzinho em tradução livre) é uma classe Java usada para estender as funcionalidades de um servidor. Apesar dos servlets poderem responder a quaisquer tipos de requisições, eles normalmente são usados para estender as aplicações hospedadas por servidores web, desta forma eles podem ser imaginados como Applets Java que rodam em servidores em vez de rodarem nos navegadores web. :robot: </p>

<p align="justify"> :robot: É importante destacar nesse ponto que o protocolo HTTP define oito métodos (GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS e CONNECT) que indicam a ação a ser realizada no recurso especificado. o método determina o que o servidor deve fazer com a URL fornecida no momento da requisição de um recurso. A classe HTTPServlet fornece uma classe abstrata para ser uma subclasse de um servlet HTTP adequados a um website. A subclasse de HTTPServlet deve substituir pelo menos um método, normalmente um deles é doGet, se o servlet suporta solicitações HTTP GET ou doPost, para solicitações HTTP POST ou os outros método suportados pela classe HTTPServlet. Basicamente você utiliza o método doGet sempre que a requisição que você faz não altere o estado do servidor, como uma consulta, uma busca e etc. O método doPost envia dados para serem processados (por exemplo, dados de um formulário HTML) para o recurso especificado. Os dados são incluídos no corpo do comando. Fonte: <a href="https://desenvolvimentoaberto.org/2014/10/13/servlet-entendendo-o-doget-e-dopost-java/">🔗 doGet - doPost</a> :robot: </p>

<p align="justify"> :robot: Desta forma teremos vamos criar utilizando  doPost - AlteraAutorServlet e NovoAutorServlet  e doGet - ListarAutoresServlet, MostrarAutorServlet e RemoveAutorServlet, sobrescrevendo o motedo através da anotação @Override; Em conjunto será utilizado a anotação @WebServleta para declarar um servlet, fornecendo a classe  anotada a possibilidade de estender a classe javax.servlet.http.HttpServlet. :robot: </p>


<p align="center">  <img src="https://www.imagensanimadas.com/data/media/1669/escritor-imagem-animada-0028.gif" width="150" height="150" /> </p>

```

/**
 * Servlet implementation class NovoAutorServlet
 */
@WebServlet("/novoAutor")
public class NovoAutorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando novo autor");
		
		String nomeAutor = request.getParameter("nome");
		String emailAutor = request.getParameter("email");
		String paramDataAutor = request.getParameter("data");
  
```

<p align="center">  <img src="https://www.imagensanimadas.com/data/media/1669/escritor-imagem-animada-0024.gif" width="150" height="150" /> </p>

```
/**
 * Servlet implementation class AlteraAutorServlet
 */

@WebServlet("/alteraAutor")
public class AlteraAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Alterando autor");
		
		String nomeAutor = request.getParameter("nome");
		String paramDataAutor = request.getParameter("data");
		String emailAutor = request.getParameter("email");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
    
```
<p align="center">  <img src="https://www.imagensanimadas.com/data/media/1669/escritor-imagem-animada-0026.gif" width="150" height="150" /> </p>

```
/**
 * Servlet implementation class ListarAutoresServlet
 */

@WebServlet("/listarAutores")
public class ListarAutoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Autor> lista = banco.getAutores();
		
		request.setAttribute("autores", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarAutores.jsp");
		rd.forward(request, response);
		
	}
}

```
<p align="center">  <img src="https://www.imagensanimadas.com/data/media/1669/escritor-imagem-animada-0030.gif" width="150" height="150" /> </p>

```
/**
 * Servlet implementation class RemoveAutorServlet
 */

@WebServlet("/removeAutor")
public class RemoveAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeAutor(id);
		
		response.sendRedirect("listarAutores");
		
	}

}

```

<p align="justify"> :robot:  Por fim é importante descrever dois métodos, sendo eles sendRedirect e RequestDispatcher:</p>
<p align="justify"> :robot: O método sendRedirect () da interface HttpServletResponse pode ser usado para redirecionar a resposta para outro recurso, que pode ser um arquivo servlet, jsp ou html. Aceita URL relativo e absoluto e funciona no lado do cliente porque usa a barra de url do navegador para fazer outra solicitação. Portanto, ele pode funcionar dentro e fora do servidor.  <a href="https://www.javatpoint.com/sendRedirect()-method">🔗 sendRedirect</a>  :robot:</p>

<p align="justify"> :robot: O método RequestDispatcher () define um objeto que recebe solicitações do cliente e as envia para qualquer recurso (como um servlet, arquivo HTML ou arquivo JSP) no servidor. O contêiner de servlet cria o RequestDispatcherobjct, que é usado como um wrapper em torno de um recurso do servidor localizado em um caminho específico ou fornecido por um nome específico. Essa interface tem como objetivo envolver servlets, mas um contêiner de servlet pode criar RequestDispatcher objetos para envolver qualquer tipo de recurso. <a href="https://docs.oracle.com/javaee/7/api/javax/servlet/RequestDispatcher.html">🔗 sendRedirect</a>  :robot:</p>
  

<p align="center">  <img src=" https://media.tenor.com/images/c664f0c31082ab41b8c170909d224ece/tenor.gif" width="150" height="150" /> </p>
 
  
<p align="justify"> :robot: Dentro deste contexto vamos utilizar o redirecionamento (sendRedirect) - com o cliente recebendo uma resposta http em cujo header haverá a informação de que ele deve requisitar outra página, e o browser fará esta requisição. Ou seja, o redirecionamento ocorrerá no lado no cliente, tais como: 
  
•	AlteraAutorServlet redireciona  para listarAutores;
•	NovoAutorServlet redireciona  para listarAutores;
•	RemoveAutorServlet redireciona para listaAutores.
  
 </p>

<p align="justify"> :robot: E teremos o encaminhamento (RequestDispatcher) - No segundo caso (forward), no lado do server a requisição do usuário será encaminhada para ser atendida por outro recurso (outro servlet). Este outro servlet eventualmente devolverá outra página para o usuário, tais como:
  
•	MostraAutorServlet encaminha para formAlteraAutor.jsp 
•	ListarAutoresServlet encaminha para listaAutores.jsp 

</p>


<h3 align="center">
    Link´s: 
  <a href="http://localhost:8080/editora/listarAutores">🔗 Lista Autores</a> 
  <a href="http://localhost:8080/editora/formNovoAutor.jsp">🔗 Cadastra novos autores </a> 
  <a href="http://localhost:8080/editora/formAlteraAutor.jsp">🔗 Editar Autores </a> 
</h3>
