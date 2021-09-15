package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.RolUserDao;
import pe.edu.upc.entities.RolUser;
import pe.edu.upc.service.RolUserService;

@Named
@RequestScoped
public class RolUserServiceImpl implements RolUserService {

	@Inject
	private RolUserDao ruDao;

	@Override
	public void insert(RolUser ru) {
		ruDao.insert(ru);
	}

	@Override
	public List<RolUser> list() {

		return ruDao.list();
	}

}
