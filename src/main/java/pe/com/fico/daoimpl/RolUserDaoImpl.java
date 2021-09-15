package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.RolUserDao;
import pe.edu.upc.entities.RolUser;

public class RolUserDaoImpl implements RolUserDao {

	@PersistenceContext(unitName = "demoPrueba")
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
