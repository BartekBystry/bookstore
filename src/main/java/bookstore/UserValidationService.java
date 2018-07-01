package bookstore;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class UserValidationService {

    public void validateUserData(CustomerRegistrationDTO dto){
        Map<String,String> errorsResult = Maps.newHashMap();
        if(dto.getFirstName().length() < 3 ){
            errorsResult.put("firstNameValRes", "Imię jest wymagane. Przynajmniej 3 znaki");
        }
        if(dto.getLastName().length() < 3){
            errorsResult.put("lastNameValRes", "Nazwisko jest wymagane. Przynajmniej 3 znaki");
        }
        if(!dto.getZipCode().matches("^[0-9]{2}-[0-9]{3}$")){
            errorsResult.put("zipCodeValRes", "Zły format. Kod pocztowy powinien mieć format 12-345");
        }
        if (StringUtils.isNotBlank(dto.getCity())){
            errorsResult.put("cityValRes", "Podanie nazwy miasta jest wymagane");
        }
        if (StringUtils.isNotBlank(dto.getCountry())){
            errorsResult.put("countryValRes", "Podanie nazwy kraju jest wymagane");
        }
        if (StringUtils.isNotBlank(dto.getStreet())){
            errorsResult.put("streetValRes", "Podanie nazwy ulicy jest wymagane");
        }
        if(!dto.getBirthDate().matches("^[1][0]"))
            errorsResult.put("streetValRes", "Zły format. Data powinna być podana w formacie RRRR-MM-DD");
    }
}
