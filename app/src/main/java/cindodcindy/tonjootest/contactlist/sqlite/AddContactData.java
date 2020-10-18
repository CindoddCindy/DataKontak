package cindodcindy.tonjootest.contactlist.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AddContactData extends SQLiteOpenHelper {
    private static final int VERSIONANSW = 3;
    private static final String DBNAMEANSW = "db_answer";
    private static final String TABLENAME = "answer";

    private static String colIDAnsw = "id_answ";
    private static String colTanggalPr = "tanggal_pr";
    private static String colDoaPr = "doa_pr";
    private static String colTanggalAnsw = "tanggal_answ";
    private static String colDoaPrAnsw = "doa_answ";

    public AddContactData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public AddContactData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
