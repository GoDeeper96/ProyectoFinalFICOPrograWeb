package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.Institution;

public interface IInstitutionService {

	public void insert(Institution vc);

	public List<Institution> list();
}
