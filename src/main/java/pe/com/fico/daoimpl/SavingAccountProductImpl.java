package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ISavingAccountProductDao;
import pe.com.fico.entities.SavingAccountProduct;

public class SavingAccountProductImpl implements ISavingAccountProductDao {

	@PersistenceContext(unitName="Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(SavingAccountProduct sa) {
		// TODO Auto-generated method stub
		try {
			em.persist(sa);			
		}catch(Exception e) {
			System.out.println("Error al insertar");
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SavingAccountProduct> list() {
		// TODO Auto-generated method stub
		List<SavingAccountProduct>lista=new ArrayList<SavingAccountProduct>();
		try {
			Query q=em.createQuery("select sa from SavingAccountProduct sa");
			lista=(List<SavingAccountProduct>)q.getResultList();
		}catch(Exception e) {
			System.out.println("Error al listar");
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
