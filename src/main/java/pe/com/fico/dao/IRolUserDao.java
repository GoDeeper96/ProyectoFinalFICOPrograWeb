package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.RolUser;

public interface IRolUserDao {

	public void insert(RolUser ru);

	List<RolUser> list();
}