package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.Institution;
import pe.com.fico.entities.Product;
import pe.com.fico.service.IInstitutionService;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class ProductController {

	@Inject
	private IProductService pService;

	@Inject
	private IInstitutionService iService;

	private Product product;
	private Institution institution;

	List<Product> listProduct;
	List<Institution> listInstitution;

	@PostConstruct
	public void init() {
		this.listInstitution = new ArrayList<Institution>();
		this.listProduct = new ArrayList<Product>();
		this.product = new Product();
		this.institution = new Institution();
		this.listaProduct();
		this.listaInstitution();
	}

	public String newProduct() {
		this.setProduct(new Product());
		return "product.xhtml";
	}

	public void listaInstitution() {
		listInstitution = iService.list();
	}

	public void insertProduct() {
		try {
			pService.insert(product);
			this.listaProduct();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listaProduct() {
		listProduct = pService.list();
	}

	// Getters and Setter
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public List<Institution> getListInstitution() {
		return listInstitution;
	}

	public void setListInstitution(List<Institution> listInstitution) {
		this.listInstitution = listInstitution;
	}

	

}
