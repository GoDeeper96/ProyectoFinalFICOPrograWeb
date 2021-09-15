package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.RolUser;
import pe.com.fico.service.IRolUserService;

@Named
@RequestScoped
public class RolUserController {

	@Inject
	private IRolUserService ruService;

	// Atributos
	private RolUser rolUser;

	List<RolUser> listaRolUser;

	@PostConstruct
	public void init() {
		this.listaRolUser = new ArrayList<RolUser>();
		this.rolUser = new RolUser();
		this.listRolUser();
	}

	public String newRolUser() {
		this.setRolUser(new RolUser());
		return "roluser.xhtml";
	}

	public void insertRolUser() {
			ruService.insert(rolUser);
			this.listRolUser();
	}

	public void listRolUser() {
		this.listaRolUser = ruService.list();
	}

	// gett and sett
	public RolUser getRolUser() {
		return rolUser;
	}

	public void setRolUser(RolUser rolUser) {
		this.rolUser = rolUser;
	}

	public List<RolUser> getListaRolUser() {
		return listaRolUser;
	}

	public void setListaRolUSer(List<RolUser> listaRolUser) {
		this.listaRolUser = listaRolUser;
	}

}
