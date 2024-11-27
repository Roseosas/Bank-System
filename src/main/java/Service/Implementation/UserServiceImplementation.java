package Service.Implementation;

import Enums.Role;
import Service.UserService;
import models.Admin;
import models.User;

import java.util.*;

public class UserServiceImplementation implements UserService {
    public class UserService {
        private Map<String, User> user = new HashMap<>();

        public boolean registerUser(User user, Role role){
            if (role.equals(Role.Admin) || role.equals(Role.Customer)){
                user.put(user.getUserId(), user);
                return true;
            }
            return false;
        }

        public User login(String email, String password){
            for (User user : user.values()) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                    return user;
                }

            }
            return null;
        }
        public List<User> getAllUsers(User loggedInUser) {
            if (loggedInuser instanceof Admin){
                return new ArrayList<>(user.values());
            }
            return Collections.emptyList();
        }
    }
}
