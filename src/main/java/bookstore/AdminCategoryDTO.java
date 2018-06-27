package bookstore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminCategoryDTO {
    private String id;
    private String text;
    private CategoryState state;
    private AdminCategoryDTO parentCat;
    private String parentCategoryId;

    public String getParent(){
        return null; //todo
    }
}
