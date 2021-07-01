package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;


/**
 * The interface User service.
 */
public interface IUserService {

    /**
     * Create int.
     *
     * @param userDto the user dto
     * @return the int
     * @throws ServiceException the service exception
     */
    int create(RegisterUserDto userDto) throws ServiceException;

    /**
     * Update int.
     *
     * @param userDto the user dto
     * @return the int
     * @throws ServiceException the service exception
     */
    int update(UserDto userDto) throws ServiceException;

    /**
     * Delete int.
     *
     * @param userId the user id
     * @return the int
     * @throws ServiceException the service exception
     */
    int delete(int userId) throws ServiceException;

    /**
     * Gets by id.
     *
     * @param userId the user id
     * @return the by id
     * @throws ServiceException the service exception
     */
    UserDto getById(int userId) throws ServiceException;

    /**
     * Gets by login.
     *
     * @param login the login
     * @return the by login
     * @throws ServiceException the service exception
     */
    UserDto getByLogin(String login) throws ServiceException;

    /**
     * Validate user user dto.
     *
     * @param loginUserDto the login user dto
     * @return the user dto
     * @throws ServiceException the service exception
     */
    UserDto validateUser(LoginUserDto loginUserDto) throws ServiceException;

    /**
     * Generate hash password string.
     *
     * @param password the password
     * @param salt     the salt
     * @return the string
     * @throws ServiceException the service exception
     */
    String generateHashPassword(String password, byte[] salt) throws ServiceException;

    /**
     * Create salt byte [ ].
     *
     * @return the byte [ ]
     */
    byte[] createSalt();


}
