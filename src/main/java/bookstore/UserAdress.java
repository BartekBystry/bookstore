package bookstore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAdress {

    private String zipCode;
    private String city;
    private String country;
    private String street;
}
