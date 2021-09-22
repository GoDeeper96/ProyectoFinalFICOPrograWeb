package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.LoanProduct;

public interface ILoanProductService {

	public void insert(LoanProduct p);
	
	public void erase(int idLoan);
	
	public void update(LoanProduct lp);

	public List<LoanProduct> list();
}
