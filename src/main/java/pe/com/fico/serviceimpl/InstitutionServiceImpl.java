package grupo3.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import grupo3.dao.IInstitutionDao;
import grupo3.entities.Institution;
import grupo3.service.IInstitutionService;

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
