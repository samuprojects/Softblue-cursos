package filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// no mundo real ler o application.properties em todas as requisições causa perda de desempenho
public class MaintenanceFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		InputStream is = null;
		Properties props = null;
		
		try {
			// ler o arquivo
			is = MaintenanceFilter.class.getResourceAsStream("/application.properties");
			
			// criar o projeto com base no conteúdo do arquivo
			props = new Properties();
			props.load(is);
		
		} finally {
			if (is != null) {
				
				is.close();
			}
		}
		
		// ler a propriedade
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if (!maintenance) {
			// se não estiver em manutenção seguir adiante
			chain.doFilter(request, response);
		} else {
			// se estiver em manutenção mandar o usuário para maintenance.jsp e não processar nada
			request.getRequestDispatcher("maintenance.jsp").forward(request, response);
		}
	}

	
	public void init(FilterConfig config) throws ServletException {

	}

	public void destroy() {

	}
}