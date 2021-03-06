package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.sqlite.AddContactData;

public class SaveContactsToStorage extends AppCompatActivity {

    private AddContactData addContactData;


    private TextView textView_first_name, textView_last_name, textView_email, textView_gender,textView_avatar;
    private ImageView imageView_avatar;
    private TextView textView_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_contacts_to_storage);
        addContactData=new AddContactData(getApplicationContext());

        textView_first_name=findViewById(R.id.tv_save_storage_first_name);
        textView_last_name=findViewById(R.id.tv_save_storage_last_name);
        textView_email=findViewById(R.id.tv_save_storage_email);
        textView_gender=findViewById(R.id.tv_save_storage_gender);
        imageView_avatar=findViewById(R.id.iv_save_storage_image);
        textView_submit=findViewById(R.id.tv_save_storage_submit);
        textView_avatar=findViewById(R.id.tv_image_url_avatar);

        if(getIntent().getExtras()!=null){
            /**
             * Jika Bundle ada, ambil data dari Bundle
             */
            Bundle bundle = getIntent().getExtras();
            textView_first_name.setText(bundle.getString("first_name"));
            textView_last_name.setText(bundle.getString("last_name"));
            textView_email.setText(bundle.getString("email"));
            textView_gender.setText(bundle.getString("gender"));
            textView_avatar.setText(bundle.getString("image"));

            Glide.with(getApplicationContext())
                    .load(bundle.getString("image"))
                    .into(imageView_avatar);


            textView_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveData();

                }
            });

        }
    }

    public  void saveData(){
        String firstName=textView_first_name.getText().toString();
        String lastName=textView_last_name.getText().toString();
        String email=textView_email.getText().toString();
        String gender=textView_gender.getText().toString();
        String imageview=imageView_avatar.toString();

        if(TextUtils.isEmpty(firstName)){
            textView_first_name.setError("First Name Empty");
        }else if(TextUtils.isEmpty(lastName)){
            textView_last_name.setError("Last Name Empty");

        }
        else {


            addContactData.insertDataAnsw(textView_first_name.getText().toString(), textView_last_name.getText().toString(), textView_email.getText().toString(), textView_gender.getText().toString());
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SaveContactsToStorage.this, ContactFromStorageList.class);
            startActivity(intent);
            finish();


        }


    }


}