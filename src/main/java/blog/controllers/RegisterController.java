package blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.forms.RegisterForm;
import blog.forms.validation.EmailExistsException;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;

@Controller
public class RegisterController
{

    @Autowired
    private NotificationService notifyService;

    @Autowired
    private UserService userService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm)
    {
	return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult)
    {
	User userDto = new User();
	if (!bindingResult.hasErrors())
	{
	    userDto = createUserAccount(registerForm, bindingResult);
	}
	if (userDto == null)
	{
	    bindingResult.addError(new ObjectError("email", "Duplicate email"));
	}
	if (bindingResult.hasErrors())
	{
	    List<ObjectError> list = bindingResult.getGlobalErrors();
	    for (ObjectError o : list)
		notifyService.addErrorMessage(o.getDefaultMessage());

	    return "users/register";
	}

	notifyService.addInfoMessage("Registration successful");
	return "redirect:/";
    }

    private User createUserAccount(RegisterForm registerForm, BindingResult result)
    {
	User registered = null;
	try
	{
	    registered = userService.registerNewUserAccount(registerForm.getUserDto());
	} catch (EmailExistsException e)
	{
	    return null;
	}
	return registered;
    }
}