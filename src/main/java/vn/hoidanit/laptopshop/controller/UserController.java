package vn.hoidanit.laptopshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestBody;

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

    @RequestMapping("/admin/user/updateUser/{id}")
    public String updateUserPage(Model model, @PathVariable long id) {
        User userInfo = this.userService.findById(id);
        model.addAttribute("updateUser", userInfo);
        return "admin/user/updateUser";
    }

    @GetMapping("/admin/user/deleteUser/{id}")
    public String showDeletePage(@PathVariable Long id, Model model) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid user ID: " + id);
        }
        // Thêm id vào model để hiển thị trong JSP
        model.addAttribute("id", id);
        // // Khởi tạo đối tượng deleteUser với id để binding
        User deleteUser = new User();
        deleteUser.setId(id);
        model.addAttribute("deleteUser", deleteUser);
        return "admin/user/deleteUser";
    }

    @PostMapping("/admin/user/delete")
    public String deleteUser(@ModelAttribute("deleteUser") User deleteUser, Model model) {
        try {
            if (deleteUser.getId() == null || deleteUser.getId() <= 0) {
                throw new IllegalArgumentException("Invalid user ID: " + deleteUser.getId());
            }
            this.userService.deleteById(deleteUser.getId());
            model.addAttribute("message", "User with ID " + deleteUser.getId() + " deleted successfully!");
            return "redirect:/admin/user"; // Trả về trang result.jsp để hiển thị kết quả
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Invalid user ID: " + e.getMessage());
            return "error";
        } catch (EmptyResultDataAccessException e) {
            model.addAttribute("error", "User not found: " + e.getMessage());
            return "error";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to delete user: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/admin/user/update")
    public String updateUser(Model model, @ModelAttribute("updateUser") User updatedUser) {
        try {
            // Lấy user hiện tại từ database dựa trên id
            User existingUser = this.userService.findById(updatedUser.getId());

            // Chỉ cập nhật các trường bạn muốn thay đổi, giữ nguyên email và password
            if (updatedUser.getFullName() != null) {
                existingUser.setFullName(updatedUser.getFullName());
            }
            if (updatedUser.getAddress() != null) {
                existingUser.setAddress(updatedUser.getAddress());
            }
            if (updatedUser.getPhone() != null) {
                existingUser.setPhone(updatedUser.getPhone());
            }

            if (updatedUser.getEmail() != null) {
                existingUser.setEmail(updatedUser.getEmail());
            }

            if (updatedUser.getPassword() != null) {
                existingUser.setPassword(updatedUser.getPassword());
            }

            // Lưu lại user đã cập nhật
            User savedUser = this.userService.handleSaveUser(existingUser);
            model.addAttribute("userInfo", savedUser); // Sử dụng user đã được lưu để đảm bảo dữ liệu mới nhất

            return "admin/user/updateResult";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update user: " + e.getMessage());
            return "error";
        }
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetail(Model model, @PathVariable long id) {
        System.out.print("id: " + id);
        model.addAttribute("id", id);
        User userInfo = this.userService.findById(id);

        model.addAttribute("email", userInfo.getEmail());
        model.addAttribute("fullName", userInfo.getFullName());
        model.addAttribute("address", userInfo.getAddress());

        return "admin/user/detail";
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
