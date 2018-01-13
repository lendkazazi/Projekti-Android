package lendkazazi.com.projektifinal.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kazazi on 10/01/2018.
 */

public interface ApiInterface {

    @GET("photos")
    Call<List<ApiModel>> getData();

}
