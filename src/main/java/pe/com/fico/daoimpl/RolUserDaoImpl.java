package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.IRolUserDao;
import pe.com.fico.entities.RolUser;

public class RolUserDaoImpl implements IRolUserDao {

	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(RolUser ru) {
		try {
			em.persist(ru);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al insertar");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolUser> list() {
		List<RolUser> lista = new ArrayList<RolUser>();
		try {
			Query q = em.createQuery("select ru from RolUser ru");
			lista = (List<RolUser>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}