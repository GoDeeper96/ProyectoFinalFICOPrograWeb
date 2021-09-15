package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ILoanProductDao;
import pe.com.fico.entities.LoanProduct;
import pe.com.fico.service.ILoanProductService;

@Named
@RequestScoped
public class LoanProductServiceImpl implements ILoanProductService{

	@Inject
	private ILoanProductDao lpDao;
	
	@Override
	public void insert(LoanProduct p) {
		// TODO Auto-generated method stub
		lpDao.insert(p);
	}

	@Override
	public List<LoanProduct> list() {
		// TODO Auto-generated method stub
		return lpDao.list();
	}

}
