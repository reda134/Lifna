package blog.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.formsdata.validation.EmailExistsException;
import blog.models.User;
import blog.repository.UserRepository;

@Service
@Primary
public class UserServiceJpaImpl implements UserService
{

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAll()
    {
	return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id)
    {
	return this.userRepo.findOne(id);
    }

    @Override
    public User create(User user)
    {
	return this.userRepo.save(user);
    }

    @Override
    public User edit(User user)
    {
	return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id)
    {
	this.userRepo.delete(id);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(User userDto) throws EmailExistsException
    {

	if (emailExist(userDto.getEmail()))
	{
	    throw new EmailExistsException("There is an account with that email adress: " + userDto.getEmail());
	}

	userRepo.save(userDto);

	return userDto;

    }

    private boolean emailExist(String email)
    {
	User user = userRepo.findByEmail(email);
	if (user != null)
	{
	    return true;
	}
	return false;
    }

    @Override
    public boolean authenticate(String username, String password)
    {
	// Provide a sample password check: username == password
	return Objects.equals(username, password);
    }
}