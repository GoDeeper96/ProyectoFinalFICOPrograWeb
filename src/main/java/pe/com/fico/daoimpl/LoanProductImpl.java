package pe.com.fico.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ILoanProductDao;
import pe.com.fico.entities.LoanProduct;

@Named
@RequestScoped
public class LoanProductImpl implements Serializable, ILoanProductDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	@Transactional
	public void erase(int idLoan) {
		try {
			LoanProduct aux=em.find(LoanProduct.class, idLoan);
			em.remove(aux);
		}catch(Exception e) {
			System.out.println(e.getMessage());
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
	
	@Transactional
	public void update(LoanProduct lp) {
		try {
			em.merge(lp);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
