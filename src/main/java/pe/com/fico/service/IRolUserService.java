package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.RolUser;

public interface IRolUserService {

	public void insert(RolUser ru);

	List<RolUser> list();
}