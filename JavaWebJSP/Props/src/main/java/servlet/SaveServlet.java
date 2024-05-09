package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Properties;

@SuppressWarnings("serial")
public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String key = request.getParameter("key");
		String value = request.getParameter("value");

		Properties.save(key, value);

		response.sendRedirect("List");  // utilizado caminho relativo pois estava dando erro em relação ao formato do professor
	}

}
