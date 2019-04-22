package fun.krisme.smartbus;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    @GET("/")
    Call<String> getBaidu();
}
