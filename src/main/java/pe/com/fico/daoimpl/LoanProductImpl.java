package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ILoanProductDao;
import pe.com.fico.entities.LoanProduct;

public class LoanProductImpl implements ILoanProductDao {

	@PersistenceContext(unitName="Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(LoanProduct lp) {
		// TODO Auto-generated method stub
		try {
			em.persist(lp);			
		}catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoanProduct> list() {
		// TODO Auto-generated method stub
		List<LoanProduct>lista=new ArrayList<LoanProduct>();
		try {
			Query q=em.createQuery("select lp from LoanProduct lp");
			lista=(List<LoanProduct>)q.getResultList();
		}catch(Exception e) {
			System.out.println("Error al listar");
		}
		return lista;
	}

}
