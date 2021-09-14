package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.UserCenterDao;
import pe.edu.upc.entities.UserCenter;
import pe.edu.upc.service.UserCenterService;

@Named
@RequestScoped
public class UserCenterServiceImpl implements UserCenterService {

	@Inject
	private UserCenterDao vDao;

	@Override
	public void insert(UserCenter vc) {
		// TODO Auto-generated method stub
		vDao.insert(vc);

	}

	@Override
	public List<UserCenter> list() {
		// TODO Auto-generated method stub
		return vDao.list();
	}

}
