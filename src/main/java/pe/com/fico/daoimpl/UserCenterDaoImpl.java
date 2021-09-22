package pe.com.fico.daoimpl;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IUserCenterDao;
import pe.com.fico.entities.UserCenter;

public class UserCenterDaoImpl implements IUserCenterDao {

	@PersistenceContext(unitName = "Fico")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(UserCenter vc) {
		// TODO Auto-generated method stub
		try {
			em.persist(vc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCenter> list() {
		// TODO Auto-generated method stub
		List<UserCenter> lista = new ArrayList<UserCenter>();
		try {
			
			Query q=em.createQuery("select v from UserCenter v");
			lista = (List<UserCenter>) q.getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}