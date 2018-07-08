package bookstore.users.DTOs;

import bookstore.users.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLogedInDTO {
    private String login;

}
