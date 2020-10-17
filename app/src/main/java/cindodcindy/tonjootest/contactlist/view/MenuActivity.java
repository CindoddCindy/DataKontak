package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import cindodcindy.tonjootest.contactlist.R;

public class MenuActivity extends AppCompatActivity {

    private ImageView imageView_ke_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        imageView_ke_list=findViewById(R.id.iv_list_contact);

        imageView_ke_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this,RvContactList.class);
                startActivity(intent);
                finish();
            }
        });
    }
}