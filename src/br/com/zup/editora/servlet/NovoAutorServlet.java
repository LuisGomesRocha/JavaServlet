package br.com.zup.editora.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
		
				
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAutor);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Autor autor = new Autor();
		autor.setNome(nomeAutor);
		autor.setEmail(emailAutor);
		autor.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(autor);
		
		request.setAttribute("autor", autor.getNome());
		response.sendRedirect("listarAutores");
		

	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		RequestDispatcher rd = req.getRequestDispatcher("/formNovoAutor.jsp");
		rd.forward(req, resp);
	}

}
