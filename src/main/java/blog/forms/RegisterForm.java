package blog.forms;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm 
{
	 
	@NotEmpty
	@Size(min = 4, max = 30, message = "Username size should be in the range [2...30]")
	private String username;
	
	 
	@NotEmpty
	@Size(min = 2, max = 30, message = "Email size should be in the range [2...30]")
	private String email;

	@NotEmpty
	@Size(min = 2, max = 30, message = "Password size should be in the range [2...30]")
	private String password;
	private String passwordConfirm;

}