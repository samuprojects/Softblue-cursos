package model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {
	
	private class NomeComparator implements Comparator<Contato> {

		@Override
		public int compare(Contato c1, Contato c2) {
			return c1.getNome().compareTo(c2.getNome());
		}		
	}
	
	private static Agenda instance; // atributo estático (pertence à classe e não ao objeto) para uso como singleton
	private Map<Integer, Contato> contatos = new HashMap<Integer, Contato>();
	private NomeComparator nomeComparator = new NomeComparator();
	private int proximoId = 1;
	
	private Agenda( ) { // construtor privado para fazer funcionar o singleton, impedindo que seja instanciado fora da classe Agenda
		Contato c = null;
		
		c = new Contato();
		c.setNome("José");
		c.setTelefone("1111-1111");
		salvar(c);
		
		c = new Contato();
		c.setNome("Maria");
		c.setTelefone("2222-2222");
		salvar(c);
		
		c = new Contato();
		c.setNome("João");
		c.setTelefone("3333-3333");
		salvar(c);
		
		c = new Contato();
		c.setNome("Nice");
		c.setTelefone("4444-4444");
		salvar(c);
	}
	
	public static Agenda getInstance() { // singleton, apenas 1 objeto Agenda durante toda a execução da aplicação
		if (instance == null) {
			instance = new Agenda();			
		}
		return instance; // retorna sempre o mesmo objeto agenda porque não estará mais nulo
	}
	
	public Set<Contato> getContatos() {
		Set<Contato> set = new TreeSet<Contato>(nomeComparator);
		set.addAll(contatos.values());
		return set;
	}
	
	public void salvar (Contato c) {
		if (c.getId() == null) {
			c.setId(gerarId());
		}
		
		contatos.put(c.getId(), c);
	}
	
	public Contato carregar(int id) {
		return contatos.get(id);
	}
	
	public void excluir(int id) {
		contatos.remove(id);
	}

	private int gerarId() {
		return proximoId++;
	}

}
