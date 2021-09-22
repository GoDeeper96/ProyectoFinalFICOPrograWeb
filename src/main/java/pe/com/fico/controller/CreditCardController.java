package pe.com.fico.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.entities.BranchCreditCard;
import pe.com.fico.entities.CreditCardProduct;
import pe.com.fico.entities.Product;
import pe.com.fico.service.IBranchCreditCardService;
import pe.com.fico.service.ICreditCardService;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class CreditCardController {

	@Inject
	private ICreditCardService lpService;

	@Inject
	private IProductService pService;
	
	@Inject
	private IBranchCreditCardService bccService;

	private CreditCardProduct creditcardproduct;
	private Product product;
	private BranchCreditCard branchcreditcard;

	List<Product> listProduct;
	List<CreditCardProduct> listCreditCardProduct;
	List<BranchCreditCard> listBranchCreditCard;

	@PostConstruct
	public void init() {
		this.listCreditCardProduct = new ArrayList<CreditCardProduct>();
		this.listProduct = new ArrayList<Product>();
		this.product = new Product();
		this.creditcardproduct = new CreditCardProduct();
		this.branchcreditcard=new BranchCreditCard();
		this.listBranchCreditCard=new ArrayList<BranchCreditCard>();
		this.listaCreditCardProduct();
		this.listaProduct();
		this.listaBranches();
	}

	// Functions
	public String newLoanProduct() {
		this.setCreditcardproduct(new CreditCardProduct());
		return "creditCardProduct.xhtml";
	}
	
	public void listaProduct() {
		for(int i=0; i<pService.list().size();i++) {
			if(pService.list().get(i).getCategory().getNameCategoryProduct().equals("Tarjeta de Credito")) {
				listProduct.add(pService.list().get(i));
			}
		}
	}
	
	public void insertCreditCardProduct() {
		try {
			lpService.insert(creditcardproduct);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void listaCreditCardProduct() {
		listCreditCardProduct=lpService.list();
	}
	
	public void listaBranches() {
		listBranchCreditCard=bccService.list();
	}

	public void eraseCreditCard(CreditCardProduct cp) {
		try {
			lpService.erase(cp.getIdCreditCard());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateCreditCard() {
		try {
			lpService.update(this.creditcardproduct);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String modifyCredit(CreditCardProduct cpp) {
		this.setCreditcardproduct(cpp);
		return "creditCardMod.xhtml";
	}
	//getters and setters
	public CreditCardProduct getCreditcardproduct() {
		return creditcardproduct;
	}

	public void setCreditcardproduct(CreditCardProduct creditcardproduct) {
		this.creditcardproduct = creditcardproduct;
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

	public List<CreditCardProduct> getListCreditCardProduct() {
		return listCreditCardProduct;
	}

	public void setListCreditCardProduct(List<CreditCardProduct> listCreditCardProduct) {
		this.listCreditCardProduct = listCreditCardProduct;
	}

	public BranchCreditCard getBranchcreditcard() {
		return branchcreditcard;
	}

	public void setBranchcreditcard(BranchCreditCard branchcreditcard) {
		this.branchcreditcard = branchcreditcard;
	}

	public List<BranchCreditCard> getListBranchCreditCard() {
		return listBranchCreditCard;
	}

	public void setListBranchCreditCard(List<BranchCreditCard> listBranchCreditCard) {
		this.listBranchCreditCard = listBranchCreditCard;
	}
	
	
}
