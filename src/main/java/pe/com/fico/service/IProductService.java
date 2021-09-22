package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.Product;

public interface IProductService {

	public void insert(Product p);

	public List<Product> list();

}
