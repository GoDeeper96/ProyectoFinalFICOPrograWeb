package pe.com.fico.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.com.fico.dao.IUserDao;
import pe.com.fico.entities.User;

@Named
public class UserDaoImpl implements IUserDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Override
	public Integer insert(User t) throws Exception {
		em.persist(t);
		return t.getCustomer().getIdClient();
	}

	@Override
	public Integer update(User t) throws Exception {
		em.merge(t);
		return t.getCustomer().getIdClient();
	}

	@Override
	public Integer delete(User t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		List<User> users = new ArrayList<User>();

		try {
		Query query = em.createQuery("select c from Users c");
		users = (List<User>) query.getResultList();
		}catch(Exception e){
		System.out.println(e.getMessage());
		}
		return users;
	}

	@Override
	public Optional<User> findById(User t) throws Exception {

		User user;
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = ?1", User.class);
		query.setParameter(1, t.getCustomer().getIdClient());

		user = query.getSingleResult();

		return Optional.of(user);
	}

	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		User user = new User();

		try {

			Query query = em.createQuery("FROM User u WHERE u.nameUser = ?1");
			query.setParameter(1, username);
			@SuppressWarnings("unchecked")
			List<User> lista = query.getResultList();
			if (!lista.isEmpty()) {
				user = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return user != null ? user.getPaswordUser() : "";
	}

	@Override
	public Optional<User> findUserByUsername(User user) throws Exception {

		User userFound;
		TypedQuery<User> query = em.createQuery("FROM User u WHERE u.nameUser = ?1 and u.paswordUser = ?2", User.class);
		query.setParameter(1, user.getNameUser());
		query.setParameter(2, user.getPaswordUser());

		userFound = query.getSingleResult();

		return Optional.of(userFound);
	}

}