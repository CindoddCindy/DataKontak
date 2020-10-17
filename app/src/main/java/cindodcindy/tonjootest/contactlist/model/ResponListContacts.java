
package cindodcindy.tonjootest.contactlist.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponListContacts {

    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResponListContacts() {
    }

    /**
     * 
     * @param data
     */
    public ResponListContacts(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public ResponListContacts withData(List<Datum> data) {
        this.data = data;
        return this;
    }

}
