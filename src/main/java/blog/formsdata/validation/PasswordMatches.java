package blog.formsdata.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches
{
    String message() default "Passwords don't match";

    Class<?>[] groups() default
    {};

    Class<? extends Payload>[] payload() default
    {};
}