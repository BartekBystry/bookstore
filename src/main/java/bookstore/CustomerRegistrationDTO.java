package bookstore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRegistrationDTO {

    private UserAdress userAdress;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String pesel;
    private String email;
    private String password;
    private String phone;
    private boolean preferEmails;
}
