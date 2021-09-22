package pe.com.fico.dao;

import java.util.List;

import pe.com.fico.entities.MethodComitionAFP;

public interface IMethodComitionAFPDao {

	public void insert(MethodComitionAFP i);

	public List<MethodComitionAFP> list();
}
