package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IProductDao;
import pe.com.fico.entities.Product;
import pe.com.fico.service.IProductService;

@Named
@RequestScoped
public class ProductServiceImpl implements IProductService {

	@Inject
	private IProductDao pDao;

	@Override
	public void insert(Product p) {
		// TODO Auto-generated method stub
		pDao.insert(p);

	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return pDao.list();
	}
	public List<Product> findByName(Product pr)
	{
		// TODO Auto-generated method stub
		return pDao.findByName(pr);
	}
}
