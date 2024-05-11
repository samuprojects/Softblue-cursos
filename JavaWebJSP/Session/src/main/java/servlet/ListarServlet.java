package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Produto;

@SuppressWarnings("serial")
public class ListarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("produtos", Produto.getpProdutos());
		request.getRequestDispatcher("/produtos.jsp").forward(request, response);
	}

}
