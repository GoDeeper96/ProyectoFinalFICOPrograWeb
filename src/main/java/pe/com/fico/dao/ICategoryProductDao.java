package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.CategoryProduct;

public interface ICategoryProductDao {

	public void insert(CategoryProduct i);

	public List<CategoryProduct> list();
}
