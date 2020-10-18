package cindodcindy.tonjootest.contactlist.model;

public class PojoContacts {
    private int idContact;
    private String fisrtNameContact;
    private String lastNameContact;
    private String emailUserContact;
    private String genderUserContact;
    private String fotoUserContact;

    public PojoContacts(){

    }

    public PojoContacts(int idContact, String fisrtNameContact, String lastNameContact, String emailUserContact, String genderUserContact) {
        this.idContact = idContact;
        this.fisrtNameContact = fisrtNameContact;
        this.lastNameContact = lastNameContact;
        this.emailUserContact = emailUserContact;
        this.genderUserContact = genderUserContact;

    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getFisrtNameContact() {
        return fisrtNameContact;
    }

    public void setFisrtNameContact(String fisrtNameContact) {
        this.fisrtNameContact = fisrtNameContact;
    }

    public String getLastNameContact() {
        return lastNameContact;
    }

    public void setLastNameContact(String lastNameContact) {
        this.lastNameContact = lastNameContact;
    }

    public String getEmailUserContact() {
        return emailUserContact;
    }

    public void setEmailUserContact(String emailUserContact) {
        this.emailUserContact = emailUserContact;
    }

    public String getGenderUserContact() {
        return genderUserContact;
    }

    public void setGenderUserContact(String genderUserContact) {
        this.genderUserContact = genderUserContact;
    }

    public String getFotoUserContact() {
        return fotoUserContact;
    }

    public void setFotoUserContact(String fotoUserContact) {
        this.fotoUserContact = fotoUserContact;
    }
}
