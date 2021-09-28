package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ISavingAccountProductDao;
import pe.com.fico.entities.SavingAccountProduct;
import pe.com.fico.service.ISavingAccountProductService;

@Named
@RequestScoped
public class SavingAccountProductServiceImpl implements ISavingAccountProductService{

	@Inject
	private ISavingAccountProductDao saDao;
	
	@Override
	public void insert(SavingAccountProduct p) {
		// TODO Auto-generated method stub
		saDao.insert(p);
	}

	@Override
	public List<SavingAccountProduct> list() {
		// TODO Auto-generated method stub
		return saDao.list();
	}
	
	public void erase(int idSaving) {
		saDao.erase(idSaving);
	}
	
	public void update(SavingAccountProduct sa) {
		saDao.update(sa);
	}

}
