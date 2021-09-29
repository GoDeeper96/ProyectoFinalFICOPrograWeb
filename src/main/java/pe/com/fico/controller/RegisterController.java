package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.edu.upc.entity.Customer;
import pe.edu.upc.entity.Rol;
import pe.edu.upc.entity.User;
import pe.edu.upc.service.ICustomerService;
import pe.edu.upc.service.IRolService;
import pe.edu.upc.service.IUserService;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICustomerService cS;
	
	@Inject
	private IRolService rS;
	
	@Inject
	private IUserService uS;
	
	private Customer customer;
	private User user;
	private Rol rol;
	private int Ro;
	
	private List<User> listUser;
	private List<Rol> listRol;
	
	@PostConstruct
	public void init() throws Exception {
		listUser = new ArrayList<>();
		listRol = new ArrayList<>();
		this.customer = new Customer();
		this.user = new User();
		this.Ro = 0;
		this.findAll();
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.user.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.user.setState("A");
			this.customer.setUser(user);
			this.user.setCustomer(customer);
			this.cS.insert(customer);
			this.findAll();

			List<Rol> roles = new ArrayList<Rol>();
			int TIPO_USUARIO = Ro;
			Rol r = new Rol();
			r.setId(TIPO_USUARIO);
			roles.add(r);
			rS.assignRolesToUser(user, roles);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return redirect;
	}
	
	
	public void findAll() throws Exception {
		listUser = uS.getAll();
		listRol = rS.getAll();
	}
	
	public void delete(User user) throws Exception {
		try {
			uS.delete(user.getId());
			findAll();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Rol> getListRol() {
		return listRol;
	}

	public void setListRol(List<Rol> listRol) {
		this.listRol = listRol;
	}

	public int getRo() {
		return Ro;
	}

	public void setRo(int ro) {
		Ro = ro;
	}

}
