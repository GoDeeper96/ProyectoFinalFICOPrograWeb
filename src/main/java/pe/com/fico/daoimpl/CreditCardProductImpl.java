package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ICreditCardProductDao;
import pe.com.fico.entities.CreditCardProduct;

public class CreditCardProductImpl implements ICreditCardProductDao {

	@PersistenceContext(unitName="Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(CreditCardProduct cp) {
		// TODO Auto-generated method stub
		try {
			em.persist(cp);			
		}catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditCardProduct> list() {
		// TODO Auto-generated method stub
		List<CreditCardProduct>lista=new ArrayList<CreditCardProduct>();
		try {
			Query q=em.createQuery("select lp from CreditCardProduct lp");
			lista=(List<CreditCardProduct>)q.getResultList();
		}catch(Exception e) {
			System.out.println("Error al listar");
		}
		return lista;
	}

}
