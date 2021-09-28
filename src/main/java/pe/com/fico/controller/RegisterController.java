package pe.com.fico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import pe.com.fico.entities.Customer;
import pe.com.fico.entities.Rol;
import pe.com.fico.entities.User;
import pe.com.fico.service.IClientService;
import pe.com.fico.service.IRolService;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IClientService cS;

	@Inject
	private IRolService rS;

	private Customer customer;
	private User user;

	private int ro;
	@PostConstruct
	public void init() {
		this.customer = new Customer();
		this.user = new User();
		this.ro=1;
	}

	public String registerUser() {
		String redirect = null;
		try {
			String password = this.user.getPaswordUser();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPaswordUser(passwordHash);
			this.user.setState("A");
			this.customer.setUser(user);
			this.user.setCustomer(customer);
			this.cS.insert(customer);
			List<Rol> roles = new ArrayList<Rol>();
			Rol r = new Rol();
			r.setIdRol(ro);
			roles.add(r);
			rS.assignRolesToUser(user, roles);
			redirect = "index?faces-redirect=true";
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return redirect;
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

	public int getRo() {
		return ro;
	}

	public void setRo(int ro) {
		this.ro = ro;
	}
	
	
}
