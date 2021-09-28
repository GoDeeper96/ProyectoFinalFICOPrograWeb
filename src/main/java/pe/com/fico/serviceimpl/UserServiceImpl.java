package pe.com.fico.serviceimpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import pe.com.fico.dao.IUserDao;
import pe.com.fico.entities.User;
import pe.com.fico.service.IUserService;

@Named
@RequestScoped
public class UserServiceImpl implements IUserService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserDao uD;

	@Transactional
	@Override
	public Integer insert(User t) throws Exception {
		return uD.insert(t);
	}

	@Transactional
	@Override
	public Integer update(User t) throws Exception {
		return uD.update(t);
	}

	@Transactional
	@Override
	public Integer delete(User t) throws Exception {
		return uD.delete(t);
	}

	@Override
	public List<User> getAll() throws Exception {
		return uD.findAll();
	}

	@Override
	public Optional<User> getOne(User t) throws Exception {
		return uD.findById(t);
	}

	@Override
	public Optional<User> authentication(User user) throws Exception {
		String password = user.getPaswordUser();

		String passwordHash = uD.getPassworHashedByUserName(user.getNameUser());

		if (BCrypt.checkpw(password, passwordHash)) {
			user.setPaswordUser(passwordHash);
			return uD.findUserByUsername(user);
		}

		return Optional.of(new User());
	}

}