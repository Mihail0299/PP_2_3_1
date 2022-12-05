package myProject.service;

import myProject.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> getUsers();
    User getUserById(Long Id);
}
