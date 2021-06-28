public class RegisterUserDto extends UserDto {

    private String password;
    private String salt;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public RegisterUserDto(int id,String login, String firstName, String lastName, String address, String password, String salt, String role, String image) {
        super(id,login, firstName, lastName, address, role, image);
        this.password = password;
        this.salt = salt;
    }
}
