import exceptions.ServiceException;


public interface IUserService {

    int create(UserDto userDto) throws ServiceException;
    int update(UserDto userDto) throws ServiceException;
    int delete(int userId) throws ServiceException;
    UserDto getById(int userId) throws ServiceException;


}
