package hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hibernate.RG;

public class Aplicacao {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();

		session.beginTransaction();

//		{ // busca FROM
//
//			String hql = "FROM Livro";
//
//			Query q = session.createQuery(hql);
//
//			List<Livro> result = q.list();
//
//			for (Livro l : result) {
//				System.out.println("Nome: " + l.getNome());
//				System.out.println("Autor: " + l.getAutor());
//				System.out.println("Editora: " + l.getEditora().getNome());
//
//			}
//
//		}

//		{ // busca SELECT
//			String hql = "SELECT l.isbn, l.nome FROM Livro l";
//			Query q = session.createQuery(hql);
//			List<Object[]> result = q.list();
//			
//			for (Object[] obj : result) {
//				System.out.println("ISBN: " + obj[0]);
//				System.out.println("Nome: " + obj[1]);
//			}
//		}

//		{ // INNER JOIN
//			String hql = "SELECT c FROM Cliente c INNER JOIN c.livros l";
//			Query q = session.createQuery(hql);
//			List<Cliente> result = q.list();
//			
//			for (Cliente c : result) {
//				System.out.println("Nome: " + c.getNome());
//				System.out.println("RG: " + c.getRg().getNumero());
//				
//			}
//		}
		
//		{ // WHERE
//			String hql = "SELECT l FROM Livro l WHERE l.editora.nome = 'Editora 2'";
//			Query q = session.createQuery(hql);
//			List<Livro> result = q.list();
//			
//			for (Livro l : result) {
//				System.out.println("Nome: " + l.getNome());
//			}
//		}
		
		{ // WHERE + LIKE
			String hql = "SELECT r FROM RG r WHERE r.cliente.nome LIKE 'C%'";
			Query q = session.createQuery(hql);
			List<RG> result = q.list();
		
			for (RG rg : result) {
				System.out.println("N: " + rg.getNumero());
			}
		}
		
		session.getTransaction().commit();
	}

}
