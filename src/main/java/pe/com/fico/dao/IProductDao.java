package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.Product;

public interface IProductDao {

	public void insert(Product i);

	public List<Product> list();
}
