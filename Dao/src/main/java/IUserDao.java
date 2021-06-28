import eu.ensup.myresto.domaine.User;

import java.sql.SQLException;

public interface IUserDao {

    int create(User user) throws SQLException;
    int update(User user);
    int delete(int userId);
    User getById(int userId);



}
