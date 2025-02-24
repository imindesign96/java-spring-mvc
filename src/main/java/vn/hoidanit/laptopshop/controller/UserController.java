package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @RequestMapping("/admin/user/createUser")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/createUser";
    }

    // lấy toàn bộ users và truyền vào table ở trang result.jsp
    @RequestMapping(value = "/admin/user")
    public String getAllUserPage(Model model) {
        List<User> allUsers = this.userService.findAll(); // chạy vào service sau đó gọi thằng repository để lấy toàn bộ
                                                          // users
        model.addAttribute("users", allUsers); // gán toàn bộ records lấy được từ db ra và truyền vào biến users
        return "result";
    }

    // Request tạo mới user để lưu vào db và sau đó chuyển hướng sang trang lấy toàn
    // bộ users luôn
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User ngocvu) {
        this.userService.handleSaveUser(ngocvu);
        return "redirect:/admin/user"; // lấy toàn bộ users luôn
    }

    // @GetMapping("/admin/user/create")
    // public String showUsers(Model model, @ModelAttribute("createUser") User
    // ngocvu) {
    // // List<User> users = this.userService.findAll();
    // model.addAttribute("users", ngocvu);
    // return "showTableUsers"; // Tên file JSP là users.jsp
    // }

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
