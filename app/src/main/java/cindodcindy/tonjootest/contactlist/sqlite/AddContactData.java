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
    private static final int VERSIONANSW = 1;
    private static final String DBCONTACT = "db_answer";
    private static final String TABLENAME = "answer";

    private static String colIdContacts="idCont";
    private static String colFirstName = "firstName";
    private static String colLastName = "lastName";
    private static String colEmail = "emailUser";
    private static String colGender = "genderUser";
    private static String colPhoto = "photoUser";

    public AddContactData(Context context) {
        super(context, DBCONTACT, null, VERSIONANSW);
    }


    public AddContactData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AddContactData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLENAME + " (" +
                colIdContacts + " INTEGER PRIMARY KEY AUTOINCREMENT, " + colFirstName + " TEXT," + colLastName + " TEXT, " + colEmail + " TEXT, " + colGender + "TEXT" +
                colPhoto + " TEXT)";
        sqLiteDatabase.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
        onCreate(sqLiteDatabase);


    }
    public void insertContactList(String firstName, String lastName, String emailUser, String genderUser, String photoUser){
        String insertData = "INSERT INTO "+ TABLENAME + " ("+ colFirstName +","+colLastName+","+colEmail+","+colGender+","+colPhoto+") VALUES ('"+firstName +"', '"+lastName+"','"+emailUser+"','"+genderUser+"','"+photoUser+"')";
        this.getWritableDatabase().execSQL(insertData);
    }

    public void updateContactsList(int id,String firstName, String lastName, String emailUser, String genderUser, String photoUser ){
        String updateData = "UPDATE "+TABLENAME+ " SET "+ colFirstName + "= '"+firstName +"', "+colLastName + "= '"+lastName + "',"+colEmail+ "='"+emailUser+"',"+colGender+"='"+genderUser+"',"+colPhoto+"='"+photoUser+"' WHERE "+colIdContacts+" ="+id;
        this.getWritableDatabase().execSQL(updateData);
    }

    public void deleteContactsList(int id){
        String deleteData = "DELETE FROM "+TABLENAME +" WHERE idCont="+id;
        this.getWritableDatabase().execSQL(deleteData);
    }

    public PojoContacts getContacts(int id){
        PojoContacts pojoContacts = null;
        String selectData = "SELECT * FROM "+TABLENAME + " WHERE idCont="+String.valueOf(id);
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            pojoContacts = new PojoContacts(Integer.parseInt(data.getString(data.getColumnIndex(colIdContacts))),
                    data.getString(data.getColumnIndex(colFirstName)), data.getString(data.getColumnIndex(colLastName)),data.getString(data.getColumnIndex(colEmail)),data.getString(data.getColumnIndex(colGender)),data.getString(data.getColumnIndex(colPhoto)));
        }
        return pojoContacts;
    }

    public List<PojoContacts> getAllContact(){
        List<PojoContacts> pojoContacts = new ArrayList<>();
        String selectData = "SELECT * FROM "+TABLENAME;
        Cursor data = this.getWritableDatabase().rawQuery(selectData, null);
        if(data.moveToFirst()){
            do{
                pojoContacts.add(new PojoContacts(Integer.parseInt(data.getString(data.getColumnIndex(colIdContacts))),
                        data.getString(data.getColumnIndex(colFirstName)), data.getString(data.getColumnIndex(colLastName)),data.getString(data.getColumnIndex(colEmail)),data.getString(data.getColumnIndex(colGender)),data.getString(data.getColumnIndex(colPhoto))));
            }while (data.moveToNext());
        }
        return pojoContacts;
    }

    public List<PojoContacts> searchContact(String keyword) {
        List<PojoContacts> pojoAnsws = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLENAME + " where " + colFirstName + " like ?", new String[] { "%" + keyword + "%" });
            if (cursor.moveToFirst()) {
                pojoAnsws = new ArrayList<PojoContacts>();
                do {
                    PojoContacts pojoContacts= new PojoContacts();
                    pojoContacts.setIdContact(cursor.getInt(0));
                    pojoContacts.setFisrtNameContact(cursor.getString(1));
                    pojoContacts.setLastNameContact(cursor.getString(2));
                    pojoContacts.setEmailUserContact(cursor.getString(3));
                    pojoContacts.setGenderUserContact(cursor.getString(4));
                    pojoAnsws.add(pojoContacts);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            pojoAnsws = null;
        }
        return pojoAnsws;
    }



}
