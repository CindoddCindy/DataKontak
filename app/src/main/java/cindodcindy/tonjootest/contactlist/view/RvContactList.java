package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.Datum;
import cindodcindy.tonjootest.contactlist.model.ResponListContacts;
import cindodcindy.tonjootest.contactlist.retrofit.RetrofitHandleLink;
import cindodcindy.tonjootest.contactlist.retrofit.RetrofitMethods;
import cindodcindy.tonjootest.contactlist.sharedpref.SharedPrefHandleUser;
import cindodcindy.tonjootest.contactlist.view.adapter.RecyclerViewContactList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RvContactList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewContactList recyclerViewContactList;
    private List<Datum> datumArrayList = new ArrayList<>();
    private RetrofitMethods retrofitMethod;
    private SharedPrefHandleUser sharedPrefHandleUser;

    private TextView textView_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_contact_list);
        sharedPrefHandleUser=new SharedPrefHandleUser(RvContactList.this);
        textView_back=findViewById(R.id.tv_back);
        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RvContactList.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.rv_list_kontak);
         recyclerViewContactList= new RecyclerViewContactList(RvContactList.this,datumArrayList);
        recyclerView.setAdapter(recyclerViewContactList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RvContactList.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        getContactList();

    }

    public void getContactList(){
        // int id = userHandleSharedPref.getZonaUserIdDariToken();
        String token  = sharedPrefHandleUser.getSpToken();

        retrofitMethod = RetrofitHandleLink.getRetrofitHandle().create(RetrofitMethods.class);
        Call<ResponListContacts> orderListCall=retrofitMethod.getListContacts(token);
        orderListCall.enqueue(new Callback<ResponListContacts>() {
            @Override
            public void onResponse(Call<ResponListContacts> call, Response<ResponListContacts> response) {

                if (response.isSuccessful()) {
                    //ResponListOrederHistoryBaru responListOrederHistoryBaru=response.body();
                    //Datum datum = (Datum) responListOrederHistoryBaru.getData();
                   // ResponListContacts responListContacts=response.body();
                  //Datum data   = (Datum) responListContacts.getData();
                    datumArrayList = response.body().getData();
                    recyclerViewContactList = new RecyclerViewContactList(RvContactList.this,datumArrayList);
                    recyclerView.setAdapter(recyclerViewContactList);
                    recyclerViewContactList.notifyDataSetChanged();

//
                }
                else {
                    // error case
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(RvContactList.this, "404 not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(RvContactList.this, "500 internal server error", Toast.LENGTH_SHORT).show();
                            break;
                        case 401:
                            Toast.makeText(RvContactList.this, "401 unauthorized", Toast.LENGTH_SHORT).show();
                            break;

                        default:
                            Toast.makeText(RvContactList.this, "unknown error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponListContacts> call, Throwable t) {
                Toast.makeText(RvContactList.this, "network failure :( inform the user and possibly retry ", Toast.LENGTH_SHORT).show();

            }
        });


    }

}