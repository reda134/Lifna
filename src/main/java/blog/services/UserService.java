package blog.services;

import java.util.List;

import blog.formsdata.validation.EmailExistsException;
import blog.models.User;
import blog.models.VerificationToken;

public interface UserService
{
    boolean authenticate(String username, String password);

    public User registerNewUserAccount(User user) throws EmailExistsException;

    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User edit(User user);

    void deleteById(Long id);

    void createVerificationToken(User user, String token);
    
    VerificationToken getVerificationToken(String VerificationToken);

    User getUser(String verificationToken);
}