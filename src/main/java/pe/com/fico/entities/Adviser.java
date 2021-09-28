package pe.com.fico.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Adviser")
public class Adviser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdviser;
	
	
	
	
	
}
