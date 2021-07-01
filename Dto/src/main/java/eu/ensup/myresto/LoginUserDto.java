package eu.ensup.myresto;

/**
 * The type Login user dto.
 */
public class LoginUserDto {

    private String login;
    private String password;


    /**
     * Instantiates a new Login user dto.
     *
     * @param login    the login
     * @param password the password
     */
    public LoginUserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
