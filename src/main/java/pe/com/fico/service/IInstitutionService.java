package grupo3.service;

import java.util.List;

import grupo3.entities.Institution;

public interface IInstitutionService {

	public void insert(Institution vc);

	public List<Institution> list();
}
