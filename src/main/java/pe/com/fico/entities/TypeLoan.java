package pe.com.fico.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TypeLoan")
public class TypeLoan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTypeLoan;
	
	@Column(name="nameTypeLoan", length=40, nullable=false)
	private String nameTypeLoan;

	public TypeLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeLoan(int idTypeLoan, String nameTypeLoan) {
		super();
		this.idTypeLoan = idTypeLoan;
		this.nameTypeLoan = nameTypeLoan;
	}

	public int getIdTypeLoan() {
		return idTypeLoan;
	}

	public void setIdTypeLoan(int idTypeLoan) {
		this.idTypeLoan = idTypeLoan;
	}

	public String getNameTypeLoan() {
		return nameTypeLoan;
	}

	public void setNameTypeLoan(String nameTypeLoan) {
		this.nameTypeLoan = nameTypeLoan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTypeLoan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeLoan other = (TypeLoan) obj;
		return idTypeLoan == other.idTypeLoan;
	}
	
	
}
