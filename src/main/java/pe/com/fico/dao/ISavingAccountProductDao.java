package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.SavingAccountProduct;

public interface ISavingAccountProductDao {

	public void insert(SavingAccountProduct sa);

	public List<SavingAccountProduct> list();
}
