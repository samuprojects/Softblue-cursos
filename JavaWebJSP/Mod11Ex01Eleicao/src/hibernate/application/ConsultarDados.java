package hibernate.application;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Candidato;

public class ConsultarDados {

	public static void main(String[] args) throws Exception {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.getCurrentSession();

		session.beginTransaction();

		mostrarCandidatosECargos(session);
		System.out.println();

		mostrarVotosDoEleitor(session);
		System.out.println();

		mostrarVotosPorCandidato(session);
		System.out.println();

		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	private static void mostrarCandidatosECargos(Session session) {
		String hql = "FROM Candidato c WHERE c.cargo.nome = 'Presidente' ORDER BY c.nome";

		Query<Candidato> q = session.createQuery(hql);
		List<Candidato> r = q.getResultList();

		for (Candidato c : r) {
			System.out.println("Nome Candidato a Presidente: " + c.getNome());
		}
	}

	@SuppressWarnings("unchecked")
	private static void mostrarVotosDoEleitor(Session session) {
		String hql = "SELECT v.candidato FROM Voto v WHERE v.eleitor.tituloEleitor = '56723'";

		Query<Candidato> q = session.createQuery(hql);
		List<Candidato> r = q.getResultList();

		for (Candidato c : r) {
			System.out.println("Candidato votado: " + c.getNome() + " (" + c.getCargo().getNome() + ")");
		}
	}

	@SuppressWarnings("unchecked")
	private static void mostrarVotosPorCandidato(Session session) {
		String hql = "SELECT c.nome, COUNT(*) FROM Voto v INNER JOIN v.candidato c GROUP BY c.nome";

		Query<Object[]> q = session.createQuery(hql);
		List<Object[]> r = q.getResultList();

		for (Object[] obj : r) {
			String nomeCandidato = (String) obj[0];
			long numVotos = (Long) obj[1];

			System.out.println("Nome: " + nomeCandidato + ", Votos: " + numVotos);
		}
	}
}