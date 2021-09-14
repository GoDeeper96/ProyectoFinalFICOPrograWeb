package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.Institution;

public interface IInstitutionDao {

	public void insert(Institution i);
	
	public List <Institution>list();
}
