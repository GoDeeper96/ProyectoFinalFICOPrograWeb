package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.Institution;
import pe.com.fico.service.IInstitutionService;

@Named
@RequestScoped
public class InstitutionController {

	// CDI
	@Inject
	private IInstitutionService iService;

	// Attributes
	private Institution institution;
	List<Institution> listInstitution;

	@PostConstruct
	public void init() {
		this.listInstitution = new ArrayList<Institution>();
		this.institution = new Institution();
		this.list();
	}
	
	//methods petition
	public String newInstitution() {
		this.setInstitution(new Institution());
		return "institution.xhtml";
	}
	
	public void insert() {
		try {
			iService.insert(institution);
			this.list();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void list() {
		listInstitution =iService.list();
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Institution> getListInstitution() {
		return listInstitution;
	}

	public void setListInstitution(List<Institution> listInstitution) {
		this.listInstitution = listInstitution;
	}
	
	

}
