
package cindodcindy.tonjootest.contactlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponRegis {

    @SerializedName("token")
    @Expose
    private String token;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponRegis() {
    }

    /**
     * 
     * @param token
     */
    public ResponRegis(String token) {
        super();
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ResponRegis withToken(String token) {
        this.token = token;
        return this;
    }

}
