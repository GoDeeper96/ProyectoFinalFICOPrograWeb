package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ITypeSavingAccountDao;
import pe.com.fico.entities.TypeSavingAccount;
import pe.com.fico.service.ITypeSavingAccountService;

@Named
@RequestScoped
public class TypeSavingAccountServiceImpl implements ITypeSavingAccountService {

	@Inject
	private ITypeSavingAccountDao iDao;

	@Override
	public void insert(TypeSavingAccount vc) {
		// TODO Auto-generated method stub
		iDao.insert(vc);
	}

	@Override
	public List<TypeSavingAccount> list() {
		// TODO Auto-generated method stub

		return iDao.list();
	}

}
