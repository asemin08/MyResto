package eu.ensup.myresto;

/**
 * The type User mapper.
 */
public class UserMapper {

    /**
     * Instantiates a new User mapper.
     */
    UserMapper() {
        throw new IllegalStateException("Mapper Class");
    }

    /**
     * Convert domaine dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    public static UserDto convertDomaineDto(User user) {
        return new UserDto(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(), user.getAddress(), user.getRole(), user.getImage());
    }

    /**
     * Convert dto domaine user.
     *
     * @param userDto the user dto
     * @return the user
     */
    public static User convertDtoDomaine(UserDto userDto) {
        if (userDto instanceof RegisterUserDto)
            return new User(userDto.getId(), userDto.getLogin(), userDto.getFirstName(), userDto.getLastName(), userDto.getAddress(), ((RegisterUserDto) userDto).getPassword(), ((RegisterUserDto) userDto).getSalt(), userDto.getRole(), userDto.getImage());
        else
            return new User(userDto.getId(), userDto.getLogin(), userDto.getFirstName(), userDto.getLastName(), userDto.getAddress(), userDto.getRole(), userDto.getImage());
    }

}
