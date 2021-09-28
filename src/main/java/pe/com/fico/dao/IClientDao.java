package pe.com.fico.dao;

import java.util.List;
import java.util.Optional;

import pe.com.fico.entities.Customer;

public interface IClientDao {

	Integer insert(Customer client) throws Exception;

	Integer update(Customer client) throws Exception;

	Integer delete(Customer client) throws Exception;

	List<Customer> findAll() throws Exception;

	Optional<Customer> findById(Customer client) throws Exception;

	List<Customer> findByName(String name) throws Exception;

	Optional<Customer> findByDni(String dni) throws Exception;
}
