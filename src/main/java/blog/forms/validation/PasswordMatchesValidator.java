package blog.forms.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import blog.forms.RegisterForm;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> { 
     
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {       
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){   
    	RegisterForm user = (RegisterForm) obj;
        return user.getPassword().equals(user.getPasswordConfirm());    
    }     
}