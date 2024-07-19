package livraria.action;

import webf.action.Action;

/**
 * Abrir a tela de formulário de login
 */
public class LoginFormAction extends Action {

	@Override
	public void process() throws Exception {
		getSession().setAttribute("menuAtivo", "login");
		forward("login.jsp");
	}
}