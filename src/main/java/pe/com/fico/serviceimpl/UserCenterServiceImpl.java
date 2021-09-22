package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IUserCenterDao;
import pe.com.fico.entities.UserCenter;
import pe.com.fico.service.IUserCenterService;

@Named
@RequestScoped
public class UserCenterServiceImpl implements IUserCenterService {

	@Inject
	private IUserCenterDao vDao;

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