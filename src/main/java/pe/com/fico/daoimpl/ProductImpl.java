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
	public List<Product> findByName(Product pr){

	    List<Product> lista=new ArrayList<Product>();
	    try {
	        Query q=em.createQuery("select pr from Product pr, Institution ins, CategoryProduct cp \r\n"
	        		+ "where pr.nameProduct like ?1 AND cp.nameCategoryProduct = ?2 AND ins.nameInstitution = ?3 AND ins.typeInstitution = ?4");
	        q.setParameter(1,"%" + pr.getNameProduct() + "%");
	        q.setParameter(2, pr.getCategory().getNameCategoryProduct());
	        q.setParameter(3, pr.getInstitution().getDInstitution()); 
	        q.setParameter(4, pr.getInstitution().getDTypeInstitution());
	        lista=(List<Product>)q.getResultList();
	    }catch(Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return lista;
	}
}
