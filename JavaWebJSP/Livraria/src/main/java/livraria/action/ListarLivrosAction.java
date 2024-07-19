package livraria.action;

import java.util.List;

import livraria.entity.Livro;
import livraria.service.LivroService;
import webf.action.Action;

/**
 * Listar os livros cadastrados
 */
public class ListarLivrosAction extends Action {

	@Override
	public void process() throws Exception {
		
		getSession().setAttribute("menuAtivo", "livros");
		
		LivroService livroService = serviceFactory.getService(LivroService.class);
		List<Livro> livros = livroService.getLivros();
		
		getRequest().setAttribute("livros", livros);
		
		forward("lista_livros.jsp");
	}
}