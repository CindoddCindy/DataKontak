package cindodcindy.tonjootest.contactlist.retrofit;

import com.google.gson.JsonObject;

import cindodcindy.tonjootest.contactlist.model.ResponLoginTonjo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitMethods {
    @Headers({
            "Content-Type:application/json"
    })

    @POST("auth/signup")
    Call<ResponLoginTonjo> registerUser(@Body JsonObject body);

}
