package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IMethodComitionAFPDao;
import pe.com.fico.entities.MethodComitionAFP;
import pe.com.fico.service.IMethodComitionAFPService;

@Named
@RequestScoped
public class MethodComitionAFPServiceImpl implements IMethodComitionAFPService {

	@Inject
	private IMethodComitionAFPDao iDao;

	@Override
	public void insert(MethodComitionAFP vc) {
		// TODO Auto-generated method stub
		iDao.insert(vc);
	}

	@Override
	public List<MethodComitionAFP> list() {
		// TODO Auto-generated method stub

		return iDao.list();
	}

}
