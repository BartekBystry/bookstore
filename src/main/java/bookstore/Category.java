package bookstore;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private Integer parentId;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parentId=" + parentId +
                '}';
    }
}
