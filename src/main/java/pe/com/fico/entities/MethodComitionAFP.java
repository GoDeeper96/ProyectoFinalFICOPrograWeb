package pe.com.fico.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MethodComitionAFP")
public class MethodComitionAFP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMethod;

	@Column(name = "nameMethod", length = 40, nullable = false)
	private String nameMethodAFP;

	public MethodComitionAFP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MethodComitionAFP(int idMethod, String nameMethodAFP) {
		super();
		this.idMethod = idMethod;
		this.nameMethodAFP = nameMethodAFP;
	}

	public int getIdMethod() {
		return idMethod;
	}

	public void setIdMethod(int idMethod) {
		this.idMethod = idMethod;
	}

	public String getNameMethodAFP() {
		return nameMethodAFP;
	}

	public void setNameMethodAFP(String nameMethodAFP) {
		this.nameMethodAFP = nameMethodAFP;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMethod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodComitionAFP other = (MethodComitionAFP) obj;
		return idMethod == other.idMethod;
	}

}
