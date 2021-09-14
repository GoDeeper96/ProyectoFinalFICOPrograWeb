package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.UserCenter;

public interface UserCenterDao {

	public void insert(UserCenter vc);

	public List<UserCenter> list();

}
