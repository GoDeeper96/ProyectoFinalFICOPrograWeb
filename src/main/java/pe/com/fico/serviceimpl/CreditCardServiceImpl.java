package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ICreditCardProductDao;
import pe.com.fico.entities.CreditCardProduct;
import pe.com.fico.service.ICreditCardService;

@Named
@RequestScoped
public class CreditCardServiceImpl implements ICreditCardService{

	@Inject
	private ICreditCardProductDao cpDao;
	
	@Override
	public void insert(CreditCardProduct p) {
		// TODO Auto-generated method stub
		cpDao.insert(p);
	}

	@Override
	public List<CreditCardProduct> list() {
		// TODO Auto-generated method stub
		return cpDao.list();
	}

}
