package livraria.action;

import java.util.ArrayList;
import java.util.List;

import livraria.entity.Usuario;
import livraria.service.UsuarioService;
import webf.action.Action;
import webf.util.StringUtils;

/**
 * Cadastrar um novo usuário no sistema
 */
public class CadastrarUsuarioAction extends Action {

	@Override
	public void process() throws Exception {
		
		String email = getRequest().getParameter("email");
		
		if (email == null) {
			// Se o parâmetro 'email' não existe é porque o usuário abriu a tela para preencher o formulário
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		// Extrair os dados digitados no formulário
		email = email.trim();
		String nome = getRequest().getParameter("nome").trim();
		String senha1 = getRequest().getParameter("senha1").trim();
		String senha2 = getRequest().getParameter("senha2").trim();
		
		// Fazer a validação dos dados digitados
		validarEmail(email);
		validarNome(nome);
		validarSenha(senha1, senha2);
		
		// Caso tenha ocorrido algum erro de validação, colocar as informações novamente na request (para permitir que o formulário
		// exiba os campos preenchidos) e voltar para a mesma tela.
		if (existemErros()) {
			definirValores(email, nome, senha1, senha2);
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		// Criar o objeto que representa o usuário
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha1);
		
		UsuarioService usuarioService = serviceFactory.getService(UsuarioService.class);
		
		// Gravar o usuário
		boolean sucesso = usuarioService.salvar(usuario);
		if (!sucesso) {
			// O usuário já existe. Recolocar os valores na request e voltar para a própria tela
			adicionarErro("Usuário já existe");
			definirValores(email, nome, senha1, senha2);
			forward("cadastrar_usuario.jsp");
			return;
		}
		
		redirect("usuario_cadastrado.jsp");
	}
	
	/**
	 * Colocar os valores submetidos pelo formulário novamente na request, para que possam ser exibidos novamente após o 
	 * carregamento da página
	 * @param email
	 * @param nome
	 * @param senha1
	 * @param senha2
	 */
	private void definirValores(String email, String nome, String senha1, String senha2) {
		getRequest().setAttribute("email", email);
		getRequest().setAttribute("nome", nome);
		getRequest().setAttribute("senha1", senha1);
		getRequest().setAttribute("senha2", senha2);
	}
	
	/**
	 * Validar o e-mail
	 * @param email
	 */
	private void validarEmail(String email) {
		if (StringUtils.isEmpty(email)) {
			adicionarErro("O e-mail é obrigatório");
		}
		
		if (email.length() > 50) {
			adicionarErro("O e-mail digitado é muito grande");
		}
		
		// Validar com base em uma expressão regular
		if (!email.matches("\\w+@\\w+\\.\\w+")) {
			adicionarErro("O e-mail digitado não tem formato válido");
		}
	}
	
	/**
	 * Validar o nome
	 * @param nome
	 */
	private void validarNome(String nome) {
		if (StringUtils.isEmpty(nome)) {
			adicionarErro("O nome é obrigatório");
		}
		
		if (nome.length() > 50) {
			adicionarErro("O nome digitado é muito grande");
		}
	}
	
	/**
	 * Validar a senha e verificar se ambas as senhas digitadas são iguais
	 * @param senha1
	 * @param senha2
	 */
	private void validarSenha(String senha1, String senha2) {
		if (StringUtils.isEmpty(senha1)) {
			adicionarErro("A senha é obrigatória");
		}
		
		if (senha1.length() > 20) {
			adicionarErro("O senha digitada é muito grande");
		}
		
		if (StringUtils.isEmpty(senha2)) {
			adicionarErro("A confirmação de senha é obrigatória");
		}
		
		if (senha2.length() > 20) {
			adicionarErro("O confirmação de senha digitada é muito grande");
		}
		
		if (!senha1.equals(senha2)) {
			adicionarErro("As senhas digitadas são diferentes");
		}
	}
	
	/**
	 * Adicionar um erro de validação na request. Isto é feito através da colocação de uma list de erros na request
	 * @param erro
	 */
	@SuppressWarnings("unchecked")
	private void adicionarErro(String erro) {
		List<String> erros = (List<String>) getRequest().getAttribute("erros");
		if (erros == null) {
			erros = new ArrayList<String>();
			getRequest().setAttribute("erros", erros);
		}
		
		erros.add(erro);
	}
	
	/**
	 * Verificar se existem erros de validação
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean existemErros() {
		List<String> erros = (List<String>) getRequest().getAttribute("erros");
		if (erros == null || erros.size() == 0) {
			return false;
		}
		return true;
	}
}