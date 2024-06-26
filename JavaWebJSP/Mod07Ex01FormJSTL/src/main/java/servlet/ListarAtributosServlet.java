package servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListarAtributosServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Enumeration<String> atributos = getServletContext().getAttributeNames();
		
		Map<String, Object> map = new TreeMap<String, Object>();
		
		while (atributos.hasMoreElements()) {
			String name = atributos.nextElement();
			
			Object value = getServletContext().getAttribute(name);
			
			map.put(name, value);
		}
		
		request.setAttribute("atributos", map);
		
		request.getRequestDispatcher("listar.jsp").forward(request, response);
	}
}