package cindodcindy.tonjootest.contactlist.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefHandleUser {
    public static final String SP_CONTACT_TEST = "spMahasiswaApp";

    public static final String SP_USERNAME = "username";
    public static final String SP_PASSWORD = "password";
    public static final String SP_TOKEN="token";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefHandleUser(Context context){
        sp = context.getSharedPreferences(SP_CONTACT_TEST, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void setSpUsername(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void setSpPassword(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public  void setSpToken(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpUsername(){
        return sp.getString(SP_USERNAME, "");
    }

    public String getSpPassword(){
        return sp.getString(SP_PASSWORD, "");
    }

    public String getSpToken(){
        return  sp.getString(SP_TOKEN,"");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
