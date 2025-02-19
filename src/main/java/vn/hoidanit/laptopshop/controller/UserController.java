package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(
            UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String hello = this.userService.handleHello();
        model.addAttribute("eric", hello);
        model.addAttribute("name", "nice to meet you");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createUser";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User ngocvu) {
        System.out.println("run here: " + ngocvu);
        model.addAttribute("fullName", ngocvu.getEmail());
        this.userService.handleSaveUser(ngocvu);
        return "result";
    }

    @PostMapping("/submitUser")
    public String handleSubmit(@RequestParam String email,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam String fullName,
            @RequestParam String address,
            Model model) {
        model.addAttribute("message", "User created successfully!");
        return "result"; // Hiển thị kết quả ở trang result.jsp
    }
}

// @RestController
// public class UserController {
// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")
// public String getHomePage() {
// return this.userService.handleHello();
// }
// }
