package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.TypeSavingAccount;

public interface ITypeSavingAccountService {

	public void insert(TypeSavingAccount vc);

	public List<TypeSavingAccount> list();
}
