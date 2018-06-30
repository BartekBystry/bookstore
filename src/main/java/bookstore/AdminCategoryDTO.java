package bookstore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

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
        return StringUtils.isBlank(parentCategoryId) ? "#" : parentCategoryId;
    }
}
