package pe.com.fico.serviceimpl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.com.fico.dao.IBranchCreditCardDao;
import pe.com.fico.entities.BranchCreditCard;
import pe.com.fico.service.IBranchCreditCardService;

@Named
@RequestScoped
public class BranchCreditCardImpl implements IBranchCreditCardService {

	@Inject
	private IBranchCreditCardDao bcDao;

	@Override
	public void insert(BranchCreditCard vc) {
		// TODO Auto-generated method stub
		bcDao.insert(vc);
	}

	@Override
	public List<BranchCreditCard> list() {
		// TODO Auto-generated method stub

		return bcDao.list();
	}

}
