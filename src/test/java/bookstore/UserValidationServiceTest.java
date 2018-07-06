package bookstore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class UserValidationServiceTest {

    @Test
    void shouldPassValidationWithProperUserData() {
        UserValidationService userValidationService = new UserValidationService();
        Map<String, String> errorsMap = userValidationService.validateUserData(createUserWithProperData());
        Assertions.assertTrue(errorsMap.isEmpty());
    }

    @Test
    void shouldNotPassValidateWithWrongBirthDate() {
        UserValidationService userValidationService = new UserValidationService();
        CustomerRegistrationDTO user = createUserWithProperData();
        user.setBirthDate("12341212");
        Map<String, String> errorsMap = userValidationService.validateUserData(user);
        Assertions.assertTrue(errorsMap.containsKey(UserValidationService.BIRTH_DATE_VAL_RES));
    }

    @Test
    void shouldNotPassValidateWithNullValues() {
        UserValidationService userValidationService = new UserValidationService();
        CustomerRegistrationDTO user = createUserWithNullValues();
        Map<String, String> errorsMap = userValidationService.validateUserData(user);
        Assertions.assertTrue(!errorsMap.isEmpty());
    }

    @Test
    void shouldPassValidationWithWhiteSpaces() {
        UserValidationService userValidationService = new UserValidationService();
        CustomerRegistrationDTO user = createUserDatawithWhiteSpaces();
        Map<String, String> errorsMap = userValidationService.validateUserData(user);
        Assertions.assertTrue(errorsMap.isEmpty());// TODO: 01.07.18
    }

    private CustomerRegistrationDTO createUserWithNullValues() {
        return new CustomerRegistrationDTO();
    }

    private CustomerRegistrationDTO createUserWithProperData() {
        CustomerRegistrationDTO customer1 = new CustomerRegistrationDTO();
        customer1.setFirstName("Bartek");
        customer1.setLastName("Bystry");
        customer1.setZipCode("93-122");
        customer1.setCity("Lodz");
        customer1.setCountry("Poland");
        customer1.setStreet("Blotna 12");
        customer1.setBirthDate("1986-07-26");
        customer1.setPersonalId("12345678910");
        customer1.setEmail("hsdjhasjhd@wp.pl");
        customer1.setPassword("1234567898765");
        customer1.setPhone("123456789");
        customer1.setPreferEmails(false);

        return customer1;
    }

    private CustomerRegistrationDTO createUserDatawithWhiteSpaces() {
        CustomerRegistrationDTO customer1 = new CustomerRegistrationDTO();
        customer1.setFirstName(" Bartek");
        customer1.setLastName(" Bystry");
        customer1.setZipCode(" 93-122");
        customer1.setCity(" Lodz");
        customer1.setCountry(" Poland");
        customer1.setStreet(" Blotna 12");
        customer1.setBirthDate(" 1986-07-26");
        customer1.setPersonalId(" 12345678910");
        customer1.setEmail(" hsdjhasjhd@wp.pl");
        customer1.setPassword(" 1234567898765");
        customer1.setPhone(" 123456789");
        customer1.setPreferEmails(false);

        return customer1;
    }
}
