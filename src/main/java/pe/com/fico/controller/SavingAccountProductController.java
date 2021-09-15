package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.Product;
import pe.com.fico.entities.SavingAccountProduct;
import pe.com.fico.service.IProductService;
import pe.com.fico.service.ISavingAccountProductService;

@Named
@RequestScoped
public class SavingAccountProductController {

	@Inject
	private ISavingAccountProductService saService;

	@Inject
	private IProductService pService;

	private SavingAccountProduct savingaccount;
	private Product product;

	List<Product> listProduct;
	List<SavingAccountProduct> listSavingAccount;

	@PostConstruct
	public void init() {
		this.listSavingAccount = new ArrayList<SavingAccountProduct>();
		this.listProduct = new ArrayList<Product>();
		this.product = new Product();
		this.savingaccount = new SavingAccountProduct();

		this.listaSavingAccountProduct();
		this.listaProduct();
	}

	// Functions
	public String newSavingAccountProduct() {
		this.setSavingaccount(new SavingAccountProduct());
		return "savingAccountProduct.xhtml";
	}
	
	public void listaProduct() {
		for(int i=0; i<pService.list().size();i++) {
			if(pService.list().get(i).getTypeProduct().equals("Cuenta de Ahorro")) {
				listProduct.add(pService.list().get(i));
			}
		}
	}
	
	public void insertSavingAccountProduct() {
		try {
			saService.insert(savingaccount);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listaSavingAccountProduct() {
		listSavingAccount=saService.list();
	}

	

	//getters and setters
	public SavingAccountProduct getSavingaccount() {
		return savingaccount;
	}

	public void setSavingaccount(SavingAccountProduct savingaccount) {
		this.savingaccount = savingaccount;
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

	public List<SavingAccountProduct> getListSavingAccount() {
		return listSavingAccount;
	}

	public void setListSavingAccount(List<SavingAccountProduct> listSavingAccount) {
		this.listSavingAccount = listSavingAccount;
	}

}
