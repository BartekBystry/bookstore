package bookstore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String pesel;
    private String email;
    private String passwordHash;
    private String phone;
    private boolean preferEmails;

}
