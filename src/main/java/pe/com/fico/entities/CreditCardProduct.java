package pe.com.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CreditCardProduct")

public class CreditCardProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCreditCard;

	@Column(name = "branchCreditCard", nullable = false)
	private String branchCreditCard;

	@Column(name = "benefitCreditCard", nullable = false)
	private String benefitCreditCard;

	@Column(name = "memebershipCreditCard", nullable = false)
	private float memebershipCreditCard;

	@ManyToOne
	@JoinColumn(name = "idProduct", nullable = false)
	private Product product;

	// Constructor
	public CreditCardProduct() {
		super();
	}

	public CreditCardProduct(int idCreditCard, String branchCreditCard, String benefitCreditCard,
			float memebershipCreditCard, Product product) {
		super();
		this.idCreditCard = idCreditCard;
		this.branchCreditCard = branchCreditCard;
		this.benefitCreditCard = benefitCreditCard;
		this.memebershipCreditCard = memebershipCreditCard;
		this.product = product;
	}

	// Getters and Setters

	public int getIdCreditCard() {
		return idCreditCard;
	}

	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}

	public String getBranchCreditCard() {
		return branchCreditCard;
	}

	public void setBranchCreditCard(String branchCreditCard) {
		this.branchCreditCard = branchCreditCard;
	}

	public String getBenefitCreditCard() {
		return benefitCreditCard;
	}

	public void setBenefitCreditCard(String benefitCreditCard) {
		this.benefitCreditCard = benefitCreditCard;
	}

	public float getMemebershipCreditCard() {
		return memebershipCreditCard;
	}

	public void setMemebershipCreditCard(float memebershipCreditCard) {
		this.memebershipCreditCard = memebershipCreditCard;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
