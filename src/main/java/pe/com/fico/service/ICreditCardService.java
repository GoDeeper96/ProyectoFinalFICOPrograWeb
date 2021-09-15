package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.CreditCardProduct;

public interface ICreditCardService {

	public void insert(CreditCardProduct p);

	public List<CreditCardProduct> list();
}
