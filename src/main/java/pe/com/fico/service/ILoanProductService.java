package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.LoanProduct;

public interface ILoanProductService {

	public void insert(LoanProduct p);

	public List<LoanProduct> list();
}
