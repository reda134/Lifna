package blog.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.models.Post;
import blog.models.User;
import blog.services.PostService;
import blog.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(Model model) {
		String password = "yassmina2";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		User user = new User(1L, "reda", hashedPassword);
		userService.create(user);
		postService.create(new Post(1, "sdsd", "sdf", user));
		List<Post> latest5Posts = postService.findLatest5();
		model.addAttribute("latest5posts", latest5Posts);
		List<Post> latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
		model.addAttribute("latest3posts", latest3Posts);
		return "index";
	}
}