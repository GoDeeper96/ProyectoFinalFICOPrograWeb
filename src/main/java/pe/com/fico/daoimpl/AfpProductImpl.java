package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IAfpProductDao;
import pe.com.fico.entities.AfpProduct;

public class AfpProductImpl implements IAfpProductDao {

	@PersistenceContext(unitName="Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(AfpProduct lp) {
		// TODO Auto-generated method stub
		try {
			em.persist(lp);			
		}catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AfpProduct> list() {
		// TODO Auto-generated method stub
		List<AfpProduct>lista=new ArrayList<AfpProduct>();
		try {
			Query q=em.createQuery("select lp from AfpProduct lp");
			lista=(List<AfpProduct>)q.getResultList();
		}catch(Exception e) {
			System.out.println("Error al listar");
		}
		return lista;
	}
	
	@Transactional
	public void erase(int idAfp) {
		AfpProduct ap=new AfpProduct();
		try {
			ap=em.getReference(AfpProduct.class, idAfp);
			em.remove(ap);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Transactional
	public void update (AfpProduct ap) {
		try {
			em.merge(ap);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AfpProduct> findByNameAfp(AfpProduct afp){
		List<AfpProduct> lista=new ArrayList<AfpProduct>();
		try {
			Query q=em.createQuery("from AfpProduct m where m.typeAfp like ?1");
			q.setParameter(1, "%"+afp.getTypeAfp()+"%");
			lista=(List<AfpProduct>)q.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	


}
