package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.sqlite.AddContactData;

public class AddContact extends AppCompatActivity {

    public EditText editText_firstName, editText_lastName, editText_emailUser, editText_genderUser;

    public TextView textView_add_subbmit;

    private AddContactData addContactData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        addContactData=new AddContactData(this);

        editText_firstName=findViewById(R.id.et_add_storage_first_name);
        editText_lastName=findViewById(R.id.et_add_storage_last_name);
        editText_emailUser=findViewById(R.id.et_add_storage_email);
        editText_genderUser=findViewById(R.id.et_add_storage_gender);

        textView_add_subbmit=findViewById(R.id.tv_add_storage_submit);

        textView_add_subbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t_1=editText_firstName.getText().toString();
                String e_1=editText_lastName.getText().toString();
                String t_2=editText_emailUser.getText().toString();
                String e_2=editText_genderUser.getText().toString();
                if(TextUtils.isEmpty(t_1)){
                    editText_firstName.setError("First Name Empty");
                }else if(TextUtils.isEmpty(e_1)){
                    editText_lastName.setError("Last Name Empty");
                }else if(TextUtils.isEmpty(t_2)){
                    editText_emailUser.setError("Email User Empty");
                }else if(TextUtils.isEmpty(e_2)){
                    editText_genderUser.setError("Gender User Empty");
                }else {
                    addContactData.insertDataAnsw(editText_firstName.getText().toString(), editText_lastName.getText().toString(), editText_emailUser.getText().toString(), editText_genderUser.getText().toString());
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddContact.this, ContactFromStorageList.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }
}