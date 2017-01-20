package blog.formsdata.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import blog.formsdata.RegisterFormData;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>
{

    @Override
    public void initialize(PasswordMatches constraintAnnotation)
    {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context)
    {
	RegisterFormData user = (RegisterFormData) obj;
	return user.getPassword().equals(user.getPasswordConfirm());
    }
}