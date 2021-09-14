package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entities.RolUser;

public interface RolUserService {

	public void insert(RolUser ru);

	List<RolUser> list();
}