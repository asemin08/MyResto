package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;


public interface IUserService {

    int create(RegisterUserDto userDto) throws ServiceException;

    int update(UserDto userDto) throws ServiceException;

    int delete(int userId) throws ServiceException;

    UserDto getById(int userId) throws ServiceException;

    UserDto getByLogin(String login) throws ServiceException;

    UserDto validateUser(LoginUserDto loginUserDto) throws ServiceException;

    String generateHashPassword(String password, byte[] salt) throws ServiceException;

    byte[] createSalt();


}
