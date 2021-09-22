package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.TypeLoan;

public interface ITypeLoanDao {

	public void insert(TypeLoan i);

	public List<TypeLoan> list();
}
