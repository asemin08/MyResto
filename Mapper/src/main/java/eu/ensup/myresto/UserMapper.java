package eu.ensup.myresto;

public class UserMapper {

    UserMapper() {
        throw new IllegalStateException("Mapper Class");
    }

    public static UserDto convertDomaineDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getRole(), user.getImage());
    }

    public static User convertDtoDomaine(UserDto userDto) {
        if (userDto instanceof RegisterUserDto)
            return new User(userDto.getId(), userDto.getLogin(), userDto.getFirstName(), userDto.getLastName(), userDto.getAddress(), ((RegisterUserDto) userDto).getPassword(), ((RegisterUserDto) userDto).getSalt(), userDto.getRole(), userDto.getImage());
        else
            return new User(userDto.getId(), userDto.getLogin(), userDto.getFirstName(), userDto.getLastName(), userDto.getAddress(), userDto.getRole(), userDto.getImage());
    }

}
