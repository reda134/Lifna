package blog.formsdata;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import blog.formsdata.validation.PasswordMatches;
import blog.formsdata.validation.ValidEmail;
import blog.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PasswordMatches
public class RegisterFormData
{

    @NotEmpty
    @Size(min = 4, max = 30, message = "Username size should be in the range [2...30]")
    private String username;

    @NotEmpty
    @ValidEmail
    private String email;

    @NotEmpty
    @Size(min = 2, max = 30, message = "Password size should be in the range [2...30]")
    private String password;
    private String passwordConfirm;

    public User getUserDto()
    {
	User user = new User();
	user.setEmail(email);
	user.setUsername(username);
	user.setPassword(password);

	return user;
    }

}