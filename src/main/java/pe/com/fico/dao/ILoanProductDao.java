package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.LoanProduct;

public interface ILoanProductDao {

	public void insert(LoanProduct lp);
	
	public void erase(int idLoanProduct);

	public void update(LoanProduct ap);
	
	public List<LoanProduct> list();
}
