package lesson05.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import lesson05.dto.Category;

public interface CategoryService {
    @GET("categories/{id}")
    Call<Category> getCategory(@Path("id") Integer id);
}
