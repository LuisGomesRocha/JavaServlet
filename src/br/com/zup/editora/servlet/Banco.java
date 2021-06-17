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
