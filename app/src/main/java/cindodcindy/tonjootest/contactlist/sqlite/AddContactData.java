package cindodcindy.tonjootest.contactlist.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import cindodcindy.tonjootest.contactlist.model.PojoContacts;

public class AddContactData extends SQLiteOpenHelper {
    private static final int VERSIONCONTACT= 1;
    private static final String DBNAMECONTACT= "db_contact";
    private static final String TABLENAMECONTACT = "contact_list";

    private static String colIDContact = "id_contact";
    private static String colFirstName = "firstName";
    private static String colLastName = "lastName";
    private static String colEmail = "col_email";
    private static String colGender = "col_gender";
    private static String colAvatar="col_avatar";

    public AddContactData(Context context) {
        super(context, DBNAMECONTACT, null, VERSIONCONTACT);
    }



    public AddContactData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLENAMECONTACT + " (" +
                colIDContact + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colFirstName + " TEXT," + colLastName + " TEXT, " + colEmail + " TEXT, " + colAvatar + " TEXT, " + colAvatar + " TEXT)";
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLENAMECONTACT);
        onCreate(sqLiteDatabase);


    }

    public void insertDataAnsw(String firstName, String lastName, String userEmail, String usergender, String userAvatar){
        String insertData = "INSERT INTO "+ TABLENAMECONTACT + " ("+ colFirstName +","+ colLastName+","+colEmail+","+ colGender+", "+colAvatar+") VALUES ('"+firstName +"', '"+lastName+"','"+userEmail+"','"+usergender+"','"+userAvatar+"')";
        this.getWritableDatabase().execSQL(insertData);
    }

}
