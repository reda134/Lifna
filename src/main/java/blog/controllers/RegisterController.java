package blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.forms.RegisterForm;
import blog.services.NotificationService;

@Controller
public class RegisterController {

    @Autowired
    private NotificationService notifyService;
    
	@RequestMapping("/users/register")
	public String register(RegisterForm registerForm) {
		return "users/register";
	}
	
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
             notifyService.addErrorMessage("Please fill the form correctly!");
             return "users/register";
        }

//        if (!userService.authenticate(
//
//             loginForm.getUsername(), loginForm.getPassword())) {
//             notifyService.addErrorMessage("Invalid login!");
//             return "users/login";
//        }

        notifyService.addInfoMessage("Registration successful");
        return "redirect:/";
    }
}