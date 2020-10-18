package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.ResponLoginTonjo;
import cindodcindy.tonjootest.contactlist.retrofit.RetrofitHandleLink;
import cindodcindy.tonjootest.contactlist.retrofit.RetrofitMethods;
import cindodcindy.tonjootest.contactlist.sharedpref.SharedPrefHandleUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText editText_username, editText_password;
    private TextView button_submit;
    SharedPrefHandleUser sharedPrefHandleUser;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_username=findViewById(R.id.et_username);
        editText_password=findViewById(R.id.et_password);
        button_submit=findViewById(R.id.btn_login_submit);
        sharedPrefHandleUser = new SharedPrefHandleUser(LoginActivity.this);

        /*
        if (sharedPrefHandleUser.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, MenuActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

         */



        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLogin();

            }
        });
    }

    public void buttonLogin(){

        String username=editText_username.getText().toString();
        String password=editText_password.getText().toString();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", String.valueOf(username));
        jsonObject.addProperty("password", String.valueOf(password));



        RetrofitMethods retrofitMethods =  RetrofitHandleLink.getRetrofitHandle().create(RetrofitMethods.class);
        Call<ResponLoginTonjo> call= retrofitMethods.registerUser(jsonObject);
        call.enqueue(new Callback<ResponLoginTonjo>() {
            @Override
            public void onResponse(Call<ResponLoginTonjo> call, Response<ResponLoginTonjo> response) {
                if(response.isSuccessful()){

                    sharedPrefHandleUser.setSpUsername(SharedPrefHandleUser.SP_USERNAME,username);
                    sharedPrefHandleUser.setSpPassword(SharedPrefHandleUser.SP_PASSWORD,password);
                    sharedPrefHandleUser.setSpToken(SharedPrefHandleUser.SP_TOKEN,response.body().getToken());

                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                    sharedPrefHandleUser.saveSPBoolean(SharedPrefHandleUser.SP_SUDAH_LOGIN, true);
                    Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(intent);
                    finish();

               /*     startActivity(new Intent(getApplicationContext(), MenuActivity.class)
                           .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();



                */


                }

                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(LoginActivity.this, " not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(LoginActivity.this, "server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(LoginActivity.this, " sorry can't authenticated, try again", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(LoginActivity.this, "unknown error ", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponLoginTonjo> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });



    }
}