package pe.com.fico.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.LoanProduct;
import pe.com.fico.entities.Product;
import pe.com.fico.entities.TypeLoan;
import pe.com.fico.service.ILoanProductService;
import pe.com.fico.service.IProductService;
import pe.com.fico.service.ITypeLoanService;

@Named
@RequestScoped
public class LoanProductController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ILoanProductService lpService;

	@Inject
	private IProductService pService;

	@Inject
	private ITypeLoanService tlService;

	private LoanProduct loanproduct;
	private Product product;
	private TypeLoan typeloan;

	List<Product> listProduct;
	List<LoanProduct> listLoanProduct;
	List<TypeLoan> listTypeLoan;

	@PostConstruct
	public void init() {
		this.listLoanProduct = new ArrayList<LoanProduct>();
		this.listProduct = new ArrayList<Product>();
		this.listTypeLoan = new ArrayList<TypeLoan>();
		this.typeloan = new TypeLoan();
		this.product = new Product();
		this.loanproduct = new LoanProduct();

		this.listaLoanProduct();
		this.listaProduct();
		this.listaTypeLoan();
	}

	// Functions
	public String newLoanProduct() {
		this.setLoanproduct(new LoanProduct());
		return "loanProduct.xhtml";
	}

	public void listaProduct() {
		for (int i = 0; i < pService.list().size(); i++) {
			if (pService.list().get(i).getCategory().getNameCategoryProduct().equals("Prestamo Personal")) {
				listProduct.add(pService.list().get(i));
			}
		}
	}

	public void insertLoanProduct() {
		try {
			lpService.insert(loanproduct);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listaTypeLoan() {
		listTypeLoan = tlService.list();
	}

	public void eraseLoan(LoanProduct lp) {
		try {
			lpService.erase(lp.getIdLoanPoduct());
			listaLoanProduct();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listaLoanProduct() {
		listLoanProduct = lpService.list();
	}
	
	public void updateLoan() {
		try {
			lpService.update(this.loanproduct);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String modifyLoan(LoanProduct lp) {
		this.setLoanproduct(lp);
		return "loanMod.xhtml";
	}

	// getters and setters
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

	public TypeLoan getTypeloan() {
		return typeloan;
	}

	public void setTypeloan(TypeLoan typeloan) {
		this.typeloan = typeloan;
	}

	public List<TypeLoan> getListTypeLoan() {
		return listTypeLoan;
	}

	public void setListTypeLoan(List<TypeLoan> listTypeLoan) {
		this.listTypeLoan = listTypeLoan;
	}

}
