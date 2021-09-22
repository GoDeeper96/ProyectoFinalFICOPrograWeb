package pe.com.fico.service;

import java.util.List;

import pe.com.fico.entities.MethodComitionAFP;

public interface IMethodComitionAFPService {

	public void insert(MethodComitionAFP vc);

	public List<MethodComitionAFP> list();
}
