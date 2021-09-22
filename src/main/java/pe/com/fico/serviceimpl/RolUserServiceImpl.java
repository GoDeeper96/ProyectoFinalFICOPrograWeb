package pe.com.fico.serviceimpl;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IRolUserDao;
import pe.com.fico.entities.RolUser;
import pe.com.fico.service.IRolUserService;

@Named
@RequestScoped
public class RolUserServiceImpl implements IRolUserService {

	@Inject
	private IRolUserDao ruDao;

	@Override
	public void insert(RolUser ru) {
		ruDao.insert(ru);
	}

	@Override
	public List<RolUser> list() {

		return ruDao.list();
	}

}