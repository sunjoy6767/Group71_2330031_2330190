package reconditionedcarimporter.group71_2330031_2330190;



import java.io.Serializable;

public class LoginPage implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public LoginPage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

