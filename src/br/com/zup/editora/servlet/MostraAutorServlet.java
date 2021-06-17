package br.com.zup.editora.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mostraAutor")
public class MostraAutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Autor autor = banco.buscaAutorPeloId(id);
		
		System.out.println(autor.getNome());

		request.setAttribute("autor", autor);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraAutor.jsp");
		rd.forward(request, response);
	}

}

