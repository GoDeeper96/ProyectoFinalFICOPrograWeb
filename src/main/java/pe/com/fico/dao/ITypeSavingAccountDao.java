package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.TypeSavingAccount;

public interface ITypeSavingAccountDao {

	public void insert(TypeSavingAccount i);

	public List<TypeSavingAccount> list();
}
