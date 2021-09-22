package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.BranchCreditCard;

public interface IBranchCreditCardService {

	public void insert(BranchCreditCard vc);

	public List<BranchCreditCard> list();
}
