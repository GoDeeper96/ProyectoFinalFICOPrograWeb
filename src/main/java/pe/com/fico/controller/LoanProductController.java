package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.LoanProduct;
import pe.com.fico.entities.Product;
import pe.com.fico.service.ILoanProductService;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class LoanProductController {

	@Inject
	private ILoanProductService lpService;

	@Inject
	private IProductService pService;

	private LoanProduct loanproduct;
	private Product product;

	List<Product> listProduct;
	List<LoanProduct> listLoanProduct;

	@PostConstruct
	public void init() {
		this.listLoanProduct = new ArrayList<LoanProduct>();
		this.listProduct = new ArrayList<Product>();
		this.product = new Product();
		this.loanproduct = new LoanProduct();

		this.listaLoanProduct();
		this.listaProduct();
	}

	// Functions
	public String newLoanProduct() {
		this.setLoanproduct(new LoanProduct());
		return "loanProduct.xhtml";
	}
	
	public void listaProduct() {
		for(int i=0; i<pService.list().size();i++) {
			if(pService.list().get(i).getTypeProduct().equals("Prestamo Personal")) {
				listProduct.add(pService.list().get(i));
			}
		}
	}
	
	public void insertLoanProduct() {
		try {
			lpService.insert(loanproduct);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listaLoanProduct() {
		listLoanProduct=lpService.list();
	}
	

	//getters and setters
	public LoanProduct getLoanproduct() {
		return loanproduct;
	}

	public void setLoanproduct(LoanProduct loanproduct) {
		this.loanproduct = loanproduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public List<LoanProduct> getListLoanProduct() {
		return listLoanProduct;
	}

	public void setListLoanProduct(List<LoanProduct> listLoanProduct) {
		this.listLoanProduct = listLoanProduct;
	}

}
