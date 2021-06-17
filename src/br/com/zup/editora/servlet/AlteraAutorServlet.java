package br.com.zup.editora.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAutor);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Autor autor = banco.buscaAutorPeloId(id);
		autor.setEmail(emailAutor);
		autor.setNome(nomeAutor);
		autor.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listarAutores");
	
	}

}
