package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entities.RolUser;

public interface RolUserDao {

	public void insert(RolUser ru);

	List<RolUser> list();
}
