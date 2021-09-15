package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IAfpProductDao;
import pe.com.fico.entities.AfpProduct;
import pe.com.fico.service.IAfpProductService;

@Named
@RequestScoped
public class AfpProductServiceImpl implements IAfpProductService{

	@Inject
	private IAfpProductDao apDao;
	
	@Override
	public void insert(AfpProduct p) {
		// TODO Auto-generated method stub
		apDao.insert(p);
	}

	@Override
	public List<AfpProduct> list() {
		// TODO Auto-generated method stub
		return apDao.list();
	}

}
