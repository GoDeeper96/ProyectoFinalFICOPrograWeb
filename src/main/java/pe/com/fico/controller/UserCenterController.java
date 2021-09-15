package pe.edu.upc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entities.RolUser;
import pe.edu.upc.entities.UserCenter;
import pe.edu.upc.service.RolUserService;
import pe.edu.upc.service.UserCenterService;

@Named
@RequestScoped
public class UserCenterController {
	// CDI
	@Inject
	private UserCenterService vService;

	@Inject
	private RolUserService ruService;

	// Atributos
	private UserCenter userCenter;
	private RolUser rolUser;

	List<UserCenter> listaUser;
	List<RolUser> listaRolUser;

	// Constructor
	@PostConstruct
	public void init() {
		this.listaUser = new ArrayList<UserCenter>();
		this.listaRolUser = new ArrayList<RolUser>();
		this.userCenter = new UserCenter();
		this.rolUser = new RolUser();
		this.list();
		this.listRolUser();
	}
	// métodos atender peticiones

	public String newUser() {
		this.setUserCenter(new UserCenter());
		return "asesor.xhtml";
	}
	
	public void listRolUser() {
		listaRolUser = ruService.list();
	}

	public void insert() {
		try {
			vService.insert(userCenter);
			this.list();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void list() {
		listaUser = vService.list();
	}

	// gett and sett
	public UserCenter getUserCenter() {
		return userCenter;
	}

	public void setUserCenter(UserCenter userCenter) {
		this.userCenter = userCenter;
	}

	public RolUser getRolUser() {
		return rolUser;
	}

	public void setRolUser(RolUser rolUser) {
		this.rolUser = rolUser;
	}

	public List<UserCenter> getListaUser() {
		return listaUser;
	}

	public void setListaUser(List<UserCenter> listaUser) {
		this.listaUser = listaUser;
	}

	public List<RolUser> getListaRolUser() {
		return listaRolUser;
	}

	public void setListaRolUser(List<RolUser> listaRolUSer) {
		this.listaRolUser = listaRolUSer;
	}

}
