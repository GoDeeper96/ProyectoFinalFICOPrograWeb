package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.UserCenter;

public interface IUserCenterService {

	public void insert(UserCenter vc);

	public List<UserCenter> list();

}