package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ICategoryProductDao;
import pe.com.fico.entities.CategoryProduct;

public class CategoryProductImpl implements ICategoryProductDao{
	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(CategoryProduct i) {
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
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub
		List<CategoryProduct> lista = new ArrayList<CategoryProduct>();
		try {
			Query q = em.createQuery("select v from CategoryProduct v"); // jpql
			lista = (List<CategoryProduct>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}
