package eu.ensup.myresto;

/**
 * The type Register user dto.
 */
public class RegisterUserDto extends UserDto {

    private String password;
    private String salt;


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

    /**
     * Gets salt.
     *
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets salt.
     *
     * @param salt the salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Instantiates a new Register user dto.
     *
     * @param id        the id
     * @param login     the login
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     * @param password  the password
     * @param salt      the salt
     * @param role      the role
     * @param image     the image
     */
    public RegisterUserDto(int id,String login, String firstName, String lastName, String address, String password, String salt, String role, String image) {
        super(id,login, firstName, lastName, address, role, image);
        this.password = password;
        this.salt = salt;
    }
}
