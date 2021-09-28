package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IProductDao;
import pe.com.fico.entities.Product;

public class ProductImpl implements IProductDao {

	@PersistenceContext(unitName="Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Product p) {
		// TODO Auto-generated method stub
		try {
			em.persist(p);
		}catch(Exception e) {
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> lista=new ArrayList<Product>();
		try {
			Query q=em.createQuery("select p from Product p");
			lista=(List<Product>) q.getResultList();
		}catch(Exception e) {
			System.out.println("Error al listar");
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findByName(Product afp){
		List<Product> lista=new ArrayList<Product>();
		try {
			Query q=em.createQuery("from Product m where m.nameProduct like ?1");
			q.setParameter(1, "%"+afp.getNameProduct()+"%");
			lista=(List<Product>)q.getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}
}
