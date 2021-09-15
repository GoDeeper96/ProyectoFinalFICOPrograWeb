package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.AfpProduct;

public interface IAfpProductService {

	public void insert(AfpProduct p);

	public List<AfpProduct> list();
}
