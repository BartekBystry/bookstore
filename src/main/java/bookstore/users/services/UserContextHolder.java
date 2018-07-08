package bookstore.users.services;

import bookstore.users.DTOs.UserLogedInDTO;
import bookstore.users.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserContextHolder {
    private static UserLogedInDTO userLogedInDTO;

    public static void logInUser(User user){
        userLogedInDTO = new UserLogedInDTO(user.getEmail());
    }

    public static String getUserLoggedIn(){
        return userLogedInDTO == null ? null : userLogedInDTO.getLogin();
    }
}