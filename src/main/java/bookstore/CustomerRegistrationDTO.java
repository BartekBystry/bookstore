package bookstore;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationDTO {
    private String firstName;
    private String lastName;
    private String zipCode;
    private String city;
    private String country;
    private String street;
    private String birthDate;
    private String personalId;
    private String email;
    private String password;
    private String phone;
    private Boolean preferEmails;
}
