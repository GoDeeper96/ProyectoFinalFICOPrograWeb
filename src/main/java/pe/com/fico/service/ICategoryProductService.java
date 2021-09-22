package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.CategoryProduct;

public interface ICategoryProductService {

	public void insert(CategoryProduct vc);

	public List<CategoryProduct> list();
}
