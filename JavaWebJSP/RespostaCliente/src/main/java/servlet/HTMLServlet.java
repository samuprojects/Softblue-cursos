package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HTMLServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			response.setContentType("text/html");
			
			out.print("<HTML>");
			out.print("<HEAD>");
			out.print("</HEAD>");
			out.print("<BODY>");
			out.print("<H1>Título da Página</H1>");
			out.print("<STRONG>Esté é um texto em negrito</STRONG>");
			out.print("</BODY></HTML>");
			
		} finally {
			if (out != null) {
				out.close();
			}
		}
		
	}

}
