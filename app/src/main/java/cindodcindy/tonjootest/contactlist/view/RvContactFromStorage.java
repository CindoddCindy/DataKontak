package cindodcindy.tonjootest.contactlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import cindodcindy.tonjootest.contactlist.R;
import cindodcindy.tonjootest.contactlist.model.PojoContacts;
import cindodcindy.tonjootest.contactlist.sqlite.AddContactData;
import cindodcindy.tonjootest.contactlist.view.adapter.RvAdapterContactFromStorage;

public class RvContactFromStorage extends AppCompatActivity {
    private RecyclerView recyclerView;

    private AddContactData addContactData;
    private RvAdapterContactFromStorage rvAdapterContactFromStorage;
    private List<PojoContacts> pojoContacts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_contact_from_storage);

        recyclerView = findViewById(R.id.rv_from_sqlite);
        rvAdapterContactFromStorage = new RvAdapterContactFromStorage(RvContactFromStorage.this,pojoContacts);
        recyclerView.setAdapter(rvAdapterContactFromStorage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RvContactFromStorage.this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}