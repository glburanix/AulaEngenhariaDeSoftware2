package br.com.academia.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.academia.modelo.Planos;


public class PlanosDAO {
	
	
	String CONSULTA_TODAS = "planos.todos";
	String CONSULTA_PORNOME = "planos.porNome";

	private EntityManagerFactory factory;
	private EntityManager em;


	public PlanosDAO() {
		super();
		if (factory == null)
			this.inicializa();
	}

	public void inicializa() {
		factory = Persistence.createEntityManagerFactory("dbacademia");
		em = factory.createEntityManager();
	}


	public boolean inserir(Planos obj) {
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletar(Planos obj) {
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean alterar(Planos obj) {
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public Planos getPeloId(int id) {

		try {
			Planos obj = em.find(Planos.class, id);
			return obj;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Planos> getTodas() {

		try {
			  Query query = em.createNamedQuery(CONSULTA_TODAS);
			  List<Planos> lista = query.getResultList();
			  return lista;

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Planos getPorNome(String nome_plano) {

		try {			
			 Query query = em.createNamedQuery(CONSULTA_PORNOME);
			 query.setParameter("t", nome_plano);
		     Planos obj = (Planos) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			return null;
		}
	}
	

	@Override
	protected void finalize() throws Throwable {
		super.finalize();

		if (factory != null)
			factory.close();

		if (em != null)
			em.close();
	}

}