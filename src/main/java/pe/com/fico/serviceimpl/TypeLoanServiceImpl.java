package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ITypeLoanDao;
import pe.com.fico.entities.TypeLoan;
import pe.com.fico.service.ITypeLoanService;

@Named
@RequestScoped
public class TypeLoanServiceImpl implements ITypeLoanService {

	@Inject
	private ITypeLoanDao iDao;

	@Override
	public void insert(TypeLoan vc) {
		// TODO Auto-generated method stub
		iDao.insert(vc);
	}

	@Override
	public List<TypeLoan> list() {
		// TODO Auto-generated method stub

		return iDao.list();
	}

}
