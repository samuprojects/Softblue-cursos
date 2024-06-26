package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Servlet para salvas os dados digitados na session
 */
@SuppressWarnings("serial")
public class CadastrarServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//obter a referência à session
		HttpSession session = request.getSession();
		
		//obter a página atual. Este parâmetro é passado através de um campo hidden no formulário
		int pagina = Integer.parseInt(request.getParameter("pagina"));
		String proximaPagina = null;
		
		//checar de qual página o usuário veio e, dependendo da página, pegar os parâmetros da request correspondentes
		if (pagina == 1) {
			String email = request.getParameter("email");
			session.setAttribute("email", email);
			proximaPagina = "/tela2.jsp";
		
		} else if (pagina == 2) {
			String nome = request.getParameter("nome");
			session.setAttribute("nome", nome);
			proximaPagina = "/tela3.jsp";
		
		} else if (pagina == 3) {
			String telefone = request.getParameter("telefone");
			session.setAttribute("telefone", telefone);
			proximaPagina = "/dados.jsp";
		}
		
		//direcionar para a próxima tela 
		request.getRequestDispatcher(proximaPagina).forward(request, response);
	}
}