package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// se quiser usar a anotação basta remover o arquivo web.xml e incluir abaixo o @WebServlet("/Mensagem")
public class MensagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print("Mensagem enviada pelo Servlet");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}