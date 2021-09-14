package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IInstitutionDao;
import pe.com.fico.entities.Institution;
import pe.com.fico.service.IInstitutionService;

@Named
@RequestScoped
public class InstitutionServiceImpl implements IInstitutionService {

	@Inject
	private IInstitutionDao iDao;

	@Override
	public void insert(Institution vc) {
		// TODO Auto-generated method stub
		iDao.insert(vc);
	}

	@Override
	public List<Institution> list() {
		// TODO Auto-generated method stub

		return iDao.list();
	}

}
