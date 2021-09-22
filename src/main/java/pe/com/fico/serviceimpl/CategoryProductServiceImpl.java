package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.ICategoryProductDao;
import pe.com.fico.entities.CategoryProduct;
import pe.com.fico.service.ICategoryProductService;

@Named
@RequestScoped
public class CategoryProductServiceImpl implements ICategoryProductService {

	@Inject
	private ICategoryProductDao iDao;

	@Override
	public void insert(CategoryProduct vc) {
		// TODO Auto-generated method stub
		iDao.insert(vc);
	}

	@Override
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub

		return iDao.list();
	}

}
