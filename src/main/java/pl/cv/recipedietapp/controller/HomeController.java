package pl.cv.recipedietapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.cv.recipedietapp.entity.User;
import pl.cv.recipedietapp.repository.RecipeRepository;
import pl.cv.recipedietapp.repository.RoleRepository;
import pl.cv.recipedietapp.repository.UserRepository;
import pl.cv.recipedietapp.service.UserServiceImpl;

import java.security.Principal;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HomeController {
    private final RecipeRepository recipeRepository;
    private final UserServiceImpl userService;

    public HomeController(RecipeRepository recipeRepository, UserServiceImpl userService) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("app/dash")
    public String app(){
        return "app/dash";
    }

    @GetMapping("create")
    public String createUser(Model model) {
        User user = new User();
        user.setUsername("123");
        user.setPassword("admin");
        user.setEmail("12345@admin.pl");
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "login";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("recipes")
    public String recipes(Model model){
        model.addAttribute("recipies", recipeRepository.findAll());
        return "recipes";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }
}
