package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.UserCenter;

public interface IUserCenterDao {

	public void insert(UserCenter vc);

	public List<UserCenter> list();

}