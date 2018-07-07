package bookstore;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserAdress implements Serializable {

    private String zipCode;
    private String city;
    private String country;
    private String street;
}
