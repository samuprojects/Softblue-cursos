package filter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class TimeFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		long inicio = System.currentTimeMillis();

		chain.doFilter(request, response);

		long fim = System.currentTimeMillis();

		long time = fim - inicio;

		
		/* versão do professor + alteração para fechamento automatico de recursos (versão original não tem)
		 * 
		try (FileWriter fw = new FileWriter("/home/minhapasta/Downloads/time.txt", true)) { // true usa o append sem sobrescrever o que já existe
			fw.write("URI: " + req.getRequestURI() + ": " + time + "ms");
			fw.write(System.getProperty("line.separator"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		*/
		
		// versão adaptada para salvar na pasta do usuário independente do sistema operacional
		String userHomeDir = System.getProperty("user.home");
		String dirPath = userHomeDir + "/Downloads";
		String filePath = dirPath + "/time.txt";

		// Verificar se o diretório existe; se não, cria-o
		File dir = new File(dirPath);
		if (!dir.exists()) {
		    dir.mkdirs(); // Criar diretórios pais se necessário
		}

		try (FileWriter fw = new FileWriter(filePath, true)) {
		    fw.write("URI: " + req.getRequestURI() + ": " + time + "ms");
		    fw.write(System.getProperty("line.separator"));
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void destroy() {
	}

}
