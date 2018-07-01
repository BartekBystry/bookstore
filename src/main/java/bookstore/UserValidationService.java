package bookstore;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class UserValidationService {

    public Map<String, String> validateUserData(CustomerRegistrationDTO dto) {
        Map<String, String> errorsResult = Maps.newHashMap();
        if (dto.getFirstName().length() < 3) {
            errorsResult.put("firstNameValRes", "Imię jest wymagane. Przynajmniej 3 znaki");
        }
        if (dto.getLastName().length() < 3) {
            errorsResult.put("lastNameValRes", "Nazwisko jest wymagane. Przynajmniej 3 znaki");
        }
        if (!dto.getZipCode().matches("^[0-9]{2}-[0-9]{3}$")) {
            errorsResult.put("zipCodeValRes", "Zły format. Kod pocztowy powinien mieć format 12-345");
        }
        if (StringUtils.isNotBlank(dto.getCity())) {
            errorsResult.put("cityValRes", "Podanie nazwy miasta jest wymagane");
        }
        if (StringUtils.isNotBlank(dto.getCountry())) {
            errorsResult.put("countryValRes", "Podanie nazwy kraju jest wymagane");
        }
        if (StringUtils.isNotBlank(dto.getStreet())) {
            errorsResult.put("streetValRes", "Podanie nazwy ulicy jest wymagane");
        }
        if (!dto.getBirthDate().matches("^([1][9][0-9]{2}|[2][0][0-1][0-9])-([0][0-9]|[1][0-2])-([12][0-9]|[0][1-9]|[3][0-1])$")) {
            errorsResult.put("streetValRes", "Zły format. Data powinna być podana w formacie RRRR-MM-DD");
        }
        if(!dto.getPersonalId().matches("^[0-9]{11}")){
            errorsResult.put("personalIdValRes", "Zły format. Numer Pesel powinien składać się z 11 cyfr");
        }
        if (!dto.getEmail().matches("^\\w+@\\w+\\.\\w+$")){
            errorsResult.put("emailValRes", "Zły format adresu e-mail");
        }
        if (dto.getPassword().length() < 10 || dto.getPassword().length() > 20){
            errorsResult.put("passwordValRes", "Hasło jest wymagane. Musi zawierać od 10 do 20 znaków");
        }
        if (dto.getPhone().length() != 9){
            errorsResult.put("phoneNumberValRes","Zły format. Numer telefonu powinien składać się z 9 cyfr");
        }
        return errorsResult;
    }
}
