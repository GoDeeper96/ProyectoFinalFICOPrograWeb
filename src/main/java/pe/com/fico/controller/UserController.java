package pe.com.fico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.Customer;
import pe.com.fico.entities.UserRol;
import pe.com.fico.service.IClientService;

@Named
@ViewScoped
public class UserController implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Inject
	private IClientService uService;
	
	private Customer client;
	private UserRol rol;
	List<Customer> listUser;

	@PostConstruct
	public void init() {
		this.listUser = new ArrayList<Customer>();
		this.client=new Customer();
		this.rol=new UserRol();
		this.listaUser();
	}

	public void listaUser() {
		try {
			listUser = uService.getAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void findByName() {
		try {
			if(client.getName().isEmpty()) {
				this.listaUser();
			}else {
				listUser=this.uService.findCustomerByName(this.getClient().getName());
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUser() {
		try {
			uService.update(client);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public String ModifAfp(Customer ap) {
		this.setClient(ap);
		return "registerMod.xhtml";

	}
	
	
	
	public void clean() {
		this.init();
	}

	public List<Customer> getListUser() {
		return listUser;
	}

	public void setListUser(List<Customer> listUser) {
		this.listUser = listUser;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	public UserRol getRol() {
		return rol;
	}

	public void setRol(UserRol rol) {
		this.rol = rol;
	}

	
}
