package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.CategoryProduct;
import pe.com.fico.entities.Institution;
import pe.com.fico.entities.Product;
import pe.com.fico.service.ICategoryProductService;
import pe.com.fico.service.IInstitutionService;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class ProductController {

	@Inject
	private IProductService pService;

	@Inject
	private IInstitutionService iService;

	@Inject
	private ICategoryProductService cService;

	private Product product;
	private Institution institution;
	private CategoryProduct category;

	List<Product> listProduct;
	List<Institution> listInstitution;
	List<CategoryProduct> listCategory;

	@PostConstruct
	public void init() {
		this.listInstitution = new ArrayList<Institution>();
		this.listProduct = new ArrayList<Product>();
		this.listCategory = new ArrayList<CategoryProduct>();
		this.product = new Product();
		this.category = new CategoryProduct();
		this.institution = new Institution();
		this.listaProduct();
		this.listaInstitution();
		this.listaCategories();
	}

	public String newProduct() {
		this.setProduct(new Product());
		return "product.xhtml";
	}

	public void listaInstitution() {
		listInstitution = iService.list();
	}

	public void listaCategories() {
		listCategory = cService.list();
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

	public List<CategoryProduct> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<CategoryProduct> listCategory) {
		this.listCategory = listCategory;
	}

	public CategoryProduct getCategory() {
		return category;
	}

	public void setCategory(CategoryProduct category) {
		this.category = category;
	}
	

}
