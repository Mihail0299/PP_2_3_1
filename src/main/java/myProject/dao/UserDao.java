package myProject.dao;

import myProject.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
