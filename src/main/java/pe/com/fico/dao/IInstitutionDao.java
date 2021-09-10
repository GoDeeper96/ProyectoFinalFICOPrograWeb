package grupo3.dao;

import java.util.List;

import grupo3.entities.Institution;

public interface IInstitutionDao {

	public void insert(Institution i);
	
	public List <Institution>list();
}
