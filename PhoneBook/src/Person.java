public class Person {
    private String firstname;
    private String lastname;
    private String tel;

    Person(String firstname, String lastname, String tel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.tel = tel;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String toString() {
        return this.firstname + " " + this.lastname + " " + this.tel;
    }
}
