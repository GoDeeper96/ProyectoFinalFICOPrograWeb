package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.AfpProduct;
import pe.com.fico.entities.MethodComitionAFP;
import pe.com.fico.entities.Product;
import pe.com.fico.service.IAfpProductService;
import pe.com.fico.service.IMethodComitionAFPService;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class AfpProductController {

	@Inject
	private IAfpProductService apService;

	@Inject
	private IProductService pService;

	@Inject
	private IMethodComitionAFPService mcaService;

	private AfpProduct afpproduct;
	private Product product;
	private MethodComitionAFP methodcomition;

	List<Product> listProduct;
	List<AfpProduct> listAfpProduct;
	List<MethodComitionAFP> listMethodComition;

	@PostConstruct
	public void init() {
		this.listAfpProduct = new ArrayList<AfpProduct>();
		this.listProduct = new ArrayList<Product>();
		this.listMethodComition = new ArrayList<MethodComitionAFP>();
		this.methodcomition = new MethodComitionAFP();
		this.product = new Product();
		this.afpproduct = new AfpProduct();

		this.listaLoanProduct();
		this.listaProduct();
		this.listaMethodComition();
	}

	// Functions
	public String newLoanProduct() {
		this.setAfpproduct(new AfpProduct());
		return "afpProduct.xhtml";
	}

	public void listaProduct() {
		for (int i = 0; i < pService.list().size(); i++) {
			if (pService.list().get(i).getCategory().getNameCategoryProduct().equals("AFP")) {
				listProduct.add(pService.list().get(i));
			}
		}
	}

	public void insertLoanProduct() {
		try {
			apService.insert(afpproduct);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void listaLoanProduct() {
		listAfpProduct = apService.list();
	}

	public void listaMethodComition() {
		listMethodComition = mcaService.list();
	}

	public void eraseAfp(AfpProduct ap) {
		try {
			apService.erase(ap.getIdAfpProduct());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateAFP() {
		try {
			apService.update(this.afpproduct);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String ModifAfp(AfpProduct ap) {
		this.setAfpproduct(ap);
		return "afpMod.xhtml";

	}

	// getters and setters

	public AfpProduct getAfpproduct() {
		return afpproduct;
	}

	public void setAfpproduct(AfpProduct afpproduct) {
		this.afpproduct = afpproduct;
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

	public List<AfpProduct> getListAfpProduct() {
		return listAfpProduct;
	}

	public void setListAfpProduct(List<AfpProduct> listAfpProduct) {
		this.listAfpProduct = listAfpProduct;
	}

	public MethodComitionAFP getMethodcomition() {
		return methodcomition;
	}

	public void setMethodcomition(MethodComitionAFP methodcomition) {
		this.methodcomition = methodcomition;
	}

	public List<MethodComitionAFP> getListMethodComition() {
		return listMethodComition;
	}

	public void setListMethodComition(List<MethodComitionAFP> listMethodComition) {
		this.listMethodComition = listMethodComition;
	}

}
