package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.BranchCreditCard;

public interface IBranchCreditCardDao {

	public void insert(BranchCreditCard i);

	public List<BranchCreditCard> list();
}
