package pe.com.fico.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.com.fico.dao.ITypeSavingAccountDao;
import pe.com.fico.entities.TypeSavingAccount;

public class TypeSavingAccountImpl implements ITypeSavingAccountDao{
	@PersistenceContext(unitName = "Fico")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(TypeSavingAccount i) {
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
	public List<TypeSavingAccount> list() {
		// TODO Auto-generated method stub
		List<TypeSavingAccount> lista = new ArrayList<TypeSavingAccount>();
		try {
			Query q = em.createQuery("select v from TypeSavingAccount v"); // jpql
			lista = (List<TypeSavingAccount>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al listar");
		}
		return lista;
	}

}
