package pe.com.fico.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CategoryProduct")
public class CategoryProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoryProduct;
	
	@Column(name="nameCategoryProduct", length=40, nullable=false)
	private String nameCategoryProduct;

	public CategoryProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryProduct(int idCategoryProduct, String nameCategoryProduct) {
		super();
		this.idCategoryProduct = idCategoryProduct;
		this.nameCategoryProduct = nameCategoryProduct;
	}

	public int getIdCategoryProduct() {
		return idCategoryProduct;
	}

	public void setIdCategoryProduct(int idCategoryProduct) {
		this.idCategoryProduct = idCategoryProduct;
	}

	public String getNameCategoryProduct() {
		return nameCategoryProduct;
	}

	public void setNameCategoryProduct(String nameCategoryProduct) {
		this.nameCategoryProduct = nameCategoryProduct;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoryProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryProduct other = (CategoryProduct) obj;
		return idCategoryProduct == other.idCategoryProduct;
	}
	
	

}
