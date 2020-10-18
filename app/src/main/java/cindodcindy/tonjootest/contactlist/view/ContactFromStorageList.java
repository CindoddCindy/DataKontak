package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.PojoContacts;
import cindodcindy.tonjootest.contactlist.sqlite.AddContactData;
import cindodcindy.tonjootest.contactlist.view.adapter.RvAdapterFromStorage;

public class ContactFromStorageList extends AppCompatActivity {

    private AddContactData addContacts;
    private RecyclerView recyclerView;
    private RvAdapterFromStorage rvAdapterFromStorage;
    private List<PojoContacts> pojoContacts = new ArrayList<>();
    private TextView textView_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_from_storage_list);

        addContacts=new AddContactData(ContactFromStorageList.this);

        textView_back=findViewById(R.id.tv_back_storage);
        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactFromStorageList.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.from_storage);
        rvAdapterFromStorage = new RvAdapterFromStorage(ContactFromStorageList.this,pojoContacts);
        recyclerView.setAdapter(rvAdapterFromStorage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ContactFromStorageList.this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pojoContacts = addContacts.getAllContacts();
        //pojoAnswArrayList= dataPrayAnsw.getAllAnsw();
        rvAdapterFromStorage = new RvAdapterFromStorage(this,pojoContacts);
        recyclerView.setAdapter(rvAdapterFromStorage);
    }
}