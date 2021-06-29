package eu.ensup.myresto;

public class UserDto {

    private int id;

    private String login;

    private String firstName;

    private String lastName;

    private String address;

    private String role;

    private String image;

    public UserDto(int id, String login, String firstName, String lastName, String address, String role, String image) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.role = role;
        this.image = image;
    }

    public UserDto(String login, String firstName, String lastName, String address, String role, String image) {
        this.id = 0;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.role = role;
        this.image = image;
    }

    public UserDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
