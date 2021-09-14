package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.UserCenter;

public interface UserCenterService {

	public void insert(UserCenter vc);

	public List<UserCenter> list();

}
