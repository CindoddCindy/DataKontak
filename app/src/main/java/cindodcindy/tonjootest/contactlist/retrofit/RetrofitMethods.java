package cindodcindy.tonjootest.contactlist.retrofit;

import com.google.gson.JsonObject;

import cindodcindy.tonjootest.contactlist.model.ResponListContacts;
import cindodcindy.tonjootest.contactlist.model.ResponLoginTonjo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitMethods {
    @Headers({
            "Content-Type:application/json"
    })

    @POST("authenticate")
    Call<ResponLoginTonjo> registerUser(@Body JsonObject body);

    @GET("contacts?token=")
    Call<ResponListContacts> getListContacts(@Query("token") String token);


}
