package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cindodcindy.tonjootest.contactlist.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editText_username, editText_password;
    private TextView button_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText_username=findViewById(R.id.et_username);
        editText_password=findViewById(R.id.et_password);
        button_submit=findViewById(R.id.btn_login_submit);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}