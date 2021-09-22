package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IBranchCreditCardDao;
import pe.com.fico.entities.BranchCreditCard;

public class BranchCreditCardImpl implements IBranchCreditCardDao{
	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(BranchCreditCard i) {
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
	public List<BranchCreditCard> list() {
		// TODO Auto-generated method stub
		List<BranchCreditCard> lista = new ArrayList<BranchCreditCard>();
		try {
			Query q = em.createQuery("select v from BranchCreditCard v"); // jpql
			lista = (List<BranchCreditCard>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}
