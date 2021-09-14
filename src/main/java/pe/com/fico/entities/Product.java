package pe.com.fico.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Product")

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	
	@Column(name="nameProduct",length=45,nullable=false)
	private String nameProduct;
	
	@Column(name="ratingProduct", nullable=false)
	private float ratingProduct;
	
	@Column(name="rateproduct",nullable=true)
	private float rateProduct;
	
	@Column (name="typeProduct", nullable= false)
	private String typeProduct;
	
	@ManyToOne
	@JoinColumn(name="idInstitution",nullable=false)
	private Institution institution;
	
	public Product() {
		super();
	}
	
	public Product(int idProduct, String nameProduct, float ratingProduct,float rateProduct, Institution institution, String typeProduct) {
		this.idProduct=idProduct;
		this.nameProduct=nameProduct;
		this.rateProduct=rateProduct;
		this.ratingProduct=ratingProduct;
		this.institution=institution;	
		this.typeProduct=typeProduct;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getRatingProduct() {
		return ratingProduct;
	}

	public void setRatingProduct(float ratingProduct) {
		this.ratingProduct = ratingProduct;
	}

	public float getRateProduct() {
		return rateProduct;
	}

	public void setRateProduct(float rateProduct) {
		this.rateProduct = rateProduct;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return idProduct == other.idProduct;
	}

	
}
