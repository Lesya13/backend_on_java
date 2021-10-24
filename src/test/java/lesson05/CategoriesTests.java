package lesson05;

import lesson05.dto.Category;
import lesson05.enums.CategoryType;
import lesson05.service.CategoryService;
import lesson05.utils.PrettyLogger;
import lesson05.utils.RetrofitUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static lesson05.utils.RetrofitUtils.getRetrofit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CategoriesTests {
    PrettyLogger prettyLogger = new PrettyLogger();

    static Retrofit client;
    static CategoryService categoryService;

    @BeforeAll
    static void beforeAll () {
        client = getRetrofit();
        categoryService = client.create(CategoryService.class);
    }

    @Test
    void getCategoryByIdTest() throws IOException {
        Integer id = CategoryType.FOOD.getId();
        Response<Category> response = categoryService
                .getCategory(id)
                .execute();
        prettyLogger.log(response.body().toString());
        assertThat(response.body().getTitle(), equalTo(CategoryType.FOOD.getTitle()));
        assertThat(response.body().getId(), equalTo(id));
    }
}
