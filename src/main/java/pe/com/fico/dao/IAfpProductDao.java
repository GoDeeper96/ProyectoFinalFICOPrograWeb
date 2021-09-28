package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.AfpProduct;

public interface IAfpProductDao {

	public void insert(AfpProduct ap);
	
	public void erase(int idAfpProduct);
	
	public void update(AfpProduct ap);

	public List<AfpProduct> list();
	
	public List<AfpProduct> findByNameAfp(AfpProduct afp);
	
}
