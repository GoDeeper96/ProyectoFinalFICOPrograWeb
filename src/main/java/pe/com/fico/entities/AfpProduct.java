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
@Table(name="AfpProduct")

public class AfpProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAfpProduct;
	
	@Column(name="typeAfp", nullable=false)
	private String typeAfp;
	
	@Column(name="methodCommissionAfp", nullable=false)
	private String methodComissionAfp;
	
	@ManyToOne
	@JoinColumn(name="idProduct",nullable= false)
	private Product product;

	//Constructor
	public AfpProduct() {
		super();
	}
	

	public AfpProduct(int idAfpProduct, String typeAfp, String methodComissionAfp, Product product) {
		super();
		this.idAfpProduct = idAfpProduct;
		this.typeAfp = typeAfp;
		this.methodComissionAfp = methodComissionAfp;
		this.product = product;
	}


	//Getters and Setters
	
	public int getIdAfpProduct() {
		return idAfpProduct;
	}


	public void setIdAfpProduct(int idAfpProduct) {
		this.idAfpProduct = idAfpProduct;
	}


	public String getTypeAfp() {
		return typeAfp;
	}


	public void setTypeAfp(String typeAfp) {
		this.typeAfp = typeAfp;
	}


	public String getMethodComissionAfp() {
		return methodComissionAfp;
	}


	public void setMethodComissionAfp(String methodComissionAfp) {
		this.methodComissionAfp = methodComissionAfp;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

}
