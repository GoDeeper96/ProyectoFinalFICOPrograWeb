package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.SavingAccountProduct;

public interface ISavingAccountProductService {

	public void insert(SavingAccountProduct sa);

	public List<SavingAccountProduct> list();
}
