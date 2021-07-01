package eu.ensup.myresto;

import java.io.Serializable;

/**
 * The type User dto.
 */
public class UserDto implements Serializable {

    private int id;

    private String login;

    private String firstName;

    private String lastName;

    private String address;

    private String role;

    private String image;

    /**
     * Instantiates a new User dto.
     *
     * @param id        the id
     * @param login     the login
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     * @param role      the role
     * @param image     the image
     */
    public UserDto(int id, String login, String firstName, String lastName, String address, String role, String image) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.role = role;
        this.image = image;
    }

    /**
     * Instantiates a new User dto.
     *
     * @param login     the login
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     * @param role      the role
     * @param image     the image
     */
    public UserDto(String login, String firstName, String lastName, String address, String role, String image) {
        this.id = 0;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.role = role;
        this.image = image;
    }

    /**
     * Instantiates a new User dto.
     */
    public UserDto() {

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }
}
