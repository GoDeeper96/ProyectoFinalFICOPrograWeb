package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ITypeLoanDao;
import pe.com.fico.entities.TypeLoan;


public class TypeLoanImpl implements ITypeLoanDao{
	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(TypeLoan i) {
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
	public List<TypeLoan> list() {
		// TODO Auto-generated method stub
		List<TypeLoan> lista = new ArrayList<TypeLoan>();
		try {
			Query q = em.createQuery("select v from TypeLoan v"); // jpql
			lista = (List<TypeLoan>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}
