package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello From Service";
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        // Kiểm tra id có hợp lệ không (tùy chọn, tùy vào yêu cầu)
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null for update");
        }
        return userRepository.save(user); // JpaRepository.save sẽ cập nhật nếu id tồn tại
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

}
