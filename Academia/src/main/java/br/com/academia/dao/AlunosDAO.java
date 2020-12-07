package br.com.academia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.academia.modelo.Alunos;


public class AlunosDAO {
	
	
	String CONSULTA_TODAS 	  = "alunos.todas";
	String CONSULTA_PORNOME = "alunos.porNome";

	private EntityManagerFactory factory;
	private EntityManager em;


	public AlunosDAO() {
		super();
		if (factory == null)
			this.inicializa();
	}

	public void inicializa() {
		factory = Persistence.createEntityManagerFactory("dbacademia");
		em = factory.createEntityManager();
	}


	public boolean inserir(Alunos obj) {
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

	public boolean deletar(Alunos obj) {
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

	public boolean alterar(Alunos obj) {
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

	
	public Alunos getPeloId(int id) {

		try {
			Alunos obj = em.find(Alunos.class, id);
			return obj;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Alunos> getTodas() {

		try {
			  Query query = em.createNamedQuery(CONSULTA_TODAS);
			  List<Alunos> lista = query.getResultList();
			  return lista;

		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Alunos getPorNome(String nome) {

		try {
			/*
			 Query query = em.createQuery("from TB_DISCIPLINA where titulo like :nome"); // a clausula select é dispensável			 
		     query.setParameter("titiulo", "%" + name + "%");
		     */			
			 Query query = em.createNamedQuery(CONSULTA_PORNOME);
			 query.setParameter("t", nome);
		     Alunos obj = (Alunos) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			return null;
		}
	}
	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();

		if (factory != null)
			factory.close();

		if (em != null)
			em.close();
	}
	
	
	
	

}