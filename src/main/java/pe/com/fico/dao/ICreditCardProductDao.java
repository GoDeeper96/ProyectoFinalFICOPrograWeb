package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.CreditCardProduct;

public interface ICreditCardProductDao {

	public void insert(CreditCardProduct lp);

	public List<CreditCardProduct> list();
}
