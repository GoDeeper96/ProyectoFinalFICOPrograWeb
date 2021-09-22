package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IMethodComitionAFPDao;
import pe.com.fico.entities.MethodComitionAFP;

public class MethodComititonAFPImp implements IMethodComitionAFPDao{
	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(MethodComitionAFP i) {
		// TODO Auto-generated method stub
		try {
			em.persist(i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MethodComitionAFP> list() {
		// TODO Auto-generated method stub
		List<MethodComitionAFP> lista = new ArrayList<MethodComitionAFP>();
		try {
			Query q = em.createQuery("select v from MethodComitionAFP v"); // jpql
			lista = (List<MethodComitionAFP>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}
