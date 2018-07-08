package bookstore.users.services;

import bookstore.users.DTOs.CustomerLoginDTO;
import bookstore.users.exceptions.PasswordDoesNotMatchException;
import bookstore.users.DAOs.UserDAO;
import bookstore.users.exceptions.UserNotExistException;
import bookstore.users.entities.User;
import org.apache.commons.codec.digest.DigestUtils;

public class UserLoginService {

    private UserDAO userDAO = new UserDAO(); //FIXME

    public void login(CustomerLoginDTO customerLoginDTO) {
        User user = userDAO.getUserList()
                .stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(customerLoginDTO.getLogin().trim()))
                .findFirst()
                .orElseThrow(() -> new UserNotExistException("User not exist"));

        if (passwordIsNotCorrect(customerLoginDTO, user)){
            throw new PasswordDoesNotMatchException("Wrong password");
        }
    }

    private boolean passwordIsNotCorrect(CustomerLoginDTO customerLoginDTO, User user) {
        return !DigestUtils.sha512Hex(customerLoginDTO.getPassword().trim()).equals(user.getPasswordHash());
    }
}
