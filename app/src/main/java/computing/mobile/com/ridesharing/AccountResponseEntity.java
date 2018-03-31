package computing.mobile.com.ridesharing;

/**
 * Created by vicky on 31/3/18.
 */

public class AccountResponseEntity {
    private String id;
    private String message;

    public AccountResponseEntity(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
