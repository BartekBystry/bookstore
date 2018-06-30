package bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class OnlyOneController {

    @RequestMapping("/")
    public String welcome (Map<String,Object> model){
        return "index";
    }

    @GetMapping("/cats")
    public String cats(Map<String, Object> model, @RequestParam(required = false) String searchText){
        SearchCategoriesService searchCategoriesService = new SearchCategoriesService();
        List<AdminCategoryDTO> categoryDTOList = searchCategoriesService.filterCategories(searchText);
        model.put("catsdata", categoryDTOList);
        return "cats";
    }
}
