package pl.cv.recipedietapp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.cv.recipedietapp.entity.User;
import pl.cv.recipedietapp.service.CurrentUser;
import pl.cv.recipedietapp.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("create")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setUsername("Lucas");
//        user.setPassword("admin");
//        user.setEmail("admin@admin.pl");
//        userService.saveUser(user);
//        return "login";
//    }

    @GetMapping("admin")
    @ResponseBody
    public String admin (@AuthenticationPrincipal CurrentUser currentUser){
        User entityUser = currentUser.getUser();
        return "Hello " + entityUser.getUsername();
    }


}
