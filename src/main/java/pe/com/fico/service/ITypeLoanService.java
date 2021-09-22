package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.TypeLoan;

public interface ITypeLoanService {

	public void insert(TypeLoan vc);

	public List<TypeLoan> list();
}
