package pe.com.fico.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FiltroEconomico")
public class FiltroEconomico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVaccinationCenter;
	
	@Column(name = "nameVaccinationCenter", length =45 ,nullable=false)
	private String nameVaccinationCenter;
	
	@Column(name = "adressVaccinationCenter", length = 65,nullable = false)
	private String adressVaccinationCenter;
	
	@Column(name = "adressVaccinationCenter", length = 65,nullable = false)
	private String adressVaccinationCenter;
	
	@Column(name = "adressVaccinationCenter", length = 65,nullable = false)
	private String adressVaccinationCenter;
	
	@Column(name = "adressVaccinationCenter", length = 65,nullable = false)
	private String adressVaccinationCenter;

	// constructor
	public FiltroEconomico() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor con parámetros
	public FiltroEconomico(int idVaccinationCenter, String nameVaccinationCenter, String adressVaccinationCenter) {
		super();
		this.idVaccinationCenter = idVaccinationCenter;
		this.nameVaccinationCenter = nameVaccinationCenter;
		this.adressVaccinationCenter = adressVaccinationCenter;
	}

	// getters and setters
	public int getIdVaccinationCenter() {
		return idVaccinationCenter;
	}

	public void setIdVaccinationCenter(int idVaccinationCenter) {
		this.idVaccinationCenter = idVaccinationCenter;
	}

	public String getNameVaccinationCenter() {
		return nameVaccinationCenter;
	}

	public void setNameVaccinationCenter(String nameVaccinationCenter) {
		this.nameVaccinationCenter = nameVaccinationCenter;
	}

	public String getAdressVaccinationCenter() {
		return adressVaccinationCenter;
	}

	public void setAdressVaccinationCenter(String adressVaccinationCenter) {
		this.adressVaccinationCenter = adressVaccinationCenter;
	}
}
