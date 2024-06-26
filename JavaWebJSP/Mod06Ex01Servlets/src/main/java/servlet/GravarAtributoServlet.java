package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet para armazenar no escopo context um atributo com um valor. O atributo e valor são fornecidos via formulário HTTP.
 */
@SuppressWarnings("serial")
public class GravarAtributoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ler os parâmetros vindos da request
		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");
		
		//colocar o atributo no escopo context
		getServletContext().setAttribute(nome, valor);
		
		//fazer o redirecionamento para o JSP indicando que o processo terminou com sucesso
		response.sendRedirect("sucesso.jsp");
	}

}