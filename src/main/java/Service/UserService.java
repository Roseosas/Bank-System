package Service;

import Enums.Role;
import models.User;

import java.util.List;

public interface UserService {
    public boolean registerUser(User user, Role role);
    public User login(String email, String password);
    public List<User> getAllUsers(User loggedInUser);
}
