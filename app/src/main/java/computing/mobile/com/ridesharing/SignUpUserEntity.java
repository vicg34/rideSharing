package computing.mobile.com.ridesharing;

/**
 * Created by vicky on 31/3/18.
 */

public class SignUpUserEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String sex;
    private String password;

    public SignUpUserEntity(String firstName, String lastName, String email, String sex, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getPassword() {
        return password;
    }




}
