import bookstore.AdminCategoryDTO;
import bookstore.Category;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LambdasExample {

    @FunctionalInterface
    public interface SuperChecker {
        boolean check(Integer value);
    }

    private class SuperCheckerImpl implements SuperChecker {
        @Override
        public boolean check(Integer value) {
            return value % 2 == 0;
        }
    }

    @Test
    void anonymousClass() {
        SuperCheckerImpl superChecker = new SuperCheckerImpl();
        boolean resultFromSuperCheckerImpl = superChecker.check(3);

        SuperChecker checker = new SuperChecker() {
            @Override
            public boolean check(Integer value) {
                return value % 2 == 0;
            }
        };

        boolean resultFromAnonymousClass = checker.check(3);

        boolean resultFromAnonymousClassImmediately = new SuperChecker() {
            @Override
            public boolean check(Integer value) {
                return value % 2 == 0;
            }
        }.check(3);

        SuperChecker superFunctionalStyleChecker = (a) -> a % 2 == 0;
        boolean resultFromLambda = superFunctionalStyleChecker.check(3);
    }

    @FunctionalInterface
    interface MathOperation {
        int operation(int a, int b);

        default String a() {
            return "hahaha";
        }
    }

    @Test
    void mathOperations() {
        // 2 + 2 = 4
        // 2 - 2 = 0
        // 3 / 1 = 3

        MathOperation adding = (x, y) -> x + y;
        int addingResult = adding.operation(2, 2); //1
        operateOnMathData(2, 2, adding);//2 - z zastosowaniem osobnej metody

        Assert.assertEquals(4, addingResult);

        MathOperation subtracting = (x, y) -> x - y;
        int subtractResult = subtracting.operation(2, 2); //1
        operateOnMathData(2, 2, (x, y) -> x - y);//2 - z zastosowaniem osobnej metody


        operateOnMathData(2, 2, (x, y) -> x / y);
        operateOnMathData(2, 2, (x, y) -> x % y);

    }

    private int operateOnMathData(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    @FunctionalInterface
    public interface MyComparator<T> {
        int customCompare(T val1, T val2);
    }

    @Test
    void compareTest() {
        Category category1 = new Category(1, "1223");
        Category category2 = new Category(3, "223");
        List<Category> categories = Lists.newArrayList(category1, category2);

        AdminCategoryDTO cat1 = AdminCategoryDTO.builder().id("1234").text("Kat 1").build();
        AdminCategoryDTO cat2 = AdminCategoryDTO.builder().id("234").text("Kat 2").build();
        List<AdminCategoryDTO> categoryDTOS = Lists.newArrayList(cat1, cat2);

        MyComparator compareByIntegerId = new MyComparator<Category>() {
            @Override
            public int customCompare(Category val1, Category val2) {
                return val1.getName().compareTo(val2.getName());
            }
        };
        
        MyComparator compareByNameUsingString = new MyComparator<Category>() {
            @Override
            public int customCompare(Category val1, Category val2) {
                return val1.getName().compareTo(val2.getName());
            }
        };

        MyComparator<Category> compareByNameUsingValue = (x, y) -> Integer.valueOf(x.getName()).compareTo(Integer.valueOf(y.getName()));
        int customCompareByStringNumberValue = compareByNameUsingValue.customCompare(category1, category2);


        int customCompareByString = compareByNameUsingString.customCompare(category1, category2);
        Assertions.assertEquals(-1, customCompareByString);

        int customCompareByIntegerId = compareByIntegerId.customCompare(category1, category2);
        Assertions.assertEquals(-1, customCompareByIntegerId);

        //pierwsze sortowanie po id
        Assertions.assertTrue(categories.get(0).getId().equals(1));
        //drugie sortowanie po name
        Assertions.assertTrue(categories.get(0).getId().equals(3));
        //trzecie sortowanie po name string
        Assertions.assertTrue(categories.get(0).getId().equals(1));
    }

}
