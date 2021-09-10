package grupo3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Institution")
public class Institution {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CInstitution;
	
	@Column(name="DInstitution",length=40,nullable=false)
	private String DInstitution; 
	
	@Column(name="DTypeInstitution",length=40,nullable=false)
	private String DTypeInstitution;
	
	@Column(name="DUrlInstitution",length=100,nullable=false)
	private String DUrlInstitution;
	
	public Institution() {
		super();
	}
	
	public Institution(int CInstitution, String DInstitution,String DTypeInstitution,String DUrlInstitution ) {
		super();
		this.CInstitution = CInstitution;
		this.DInstitution = DInstitution;
		this.DTypeInstitution = DTypeInstitution;
		this.DUrlInstitution = DUrlInstitution;
	}

	public int getCInstitution() {
		return CInstitution;
	}

	public void setCInstitution(int cInstitution) {
		CInstitution = cInstitution;
	}

	public String getDInstitution() {
		return DInstitution;
	}

	public void setDInstitution(String dInstitution) {
		DInstitution = dInstitution;
	}

	public String getDTypeInstitution() {
		return DTypeInstitution;
	}

	public void setDTypeInstitution(String dTypeInstitution) {
		DTypeInstitution = dTypeInstitution;
	}

	public String getDUrlInstitution() {
		return DUrlInstitution;
	}

	public void setDUrlInstitution(String dUrlInstitution) {
		DUrlInstitution = dUrlInstitution;
	}	

}
