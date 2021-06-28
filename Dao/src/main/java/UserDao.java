import eu.ensup.myresto.domaine.User;
import exceptions.DaoException;

import java.sql.SQLException;

public class UserDao extends BaseDao implements IUserDao {

    @Override
    public int create(User user) throws DaoException {

        try {
            connexion();
            setPs(getCn().prepareStatement("INSERT INTO user(firstname,lastname,address,role,password,salt,image) VALUES(?,?,?,?,?,?,?) "));
            getPs().setString(1, user.getFirstName());
            getPs().setString(2, user.getLastName());
            getPs().setString(3, user.getAddress());
            getPs().setString(4, user.getRole());
            getPs().setString(5, user.getPassword());
            getPs().setString(6, user.getSalt());
            getPs().setString(7, user.getImage());
            setResult(getPs().executeUpdate());
            disconnect();
            return getResult();
        } catch (SQLException e) {
            throw new DaoException(UserDao.class.getName(),"create",e.getMessage(),"Une erreur s'est produite lors de la création de l'utilisateur");
        }
    }

    @Override

    public int update(User user) throws DaoException  {
        try {
            connexion();
            setPs(getCn().prepareStatement("UPDATE user SET firstname = ?, lastname = ?, address = ?, role = ?, password = ?, salt = ?, image = ? where id = ?"));
            getPs().setString(1, user.getFirstName());
            getPs().setString(2, user.getLastName());
            getPs().setString(3, user.getAddress());
            getPs().setString(4, user.getRole());
            getPs().setString(5, user.getPassword());
            getPs().setString(6, user.getSalt());
            getPs().setString(7, user.getImage());
            getPs().setInt(8, user.getId());
            setResult(getPs().executeUpdate());
            disconnect();
            return getResult();
        } catch (SQLException e) {
            throw new DaoException(UserDao.class.getName(),"create",e.getMessage(),"Une erreur s'est produite lors de la mise à jour d'utilisateur");
        }
    }

    @Override
    public int delete(int userId) {
        try {
            connexion();
            setPs(getCn().prepareStatement("delete from user where id = ?"));
            getPs().setInt(1, userId);
            setResult(getPs().executeUpdate());
            disconnect();
            return getResult();
        } catch (SQLException e) {
            throw new DaoException(UserDao.class.getName(),"create",e.getMessage(),"Une erreur s'est produite lors de la suppression de l'utilisateur");
        }
    }


    @Override
    public User getById(int userId) {
        User getUser = null;
        try {
            connexion();
            setPs(getCn().prepareStatement("SELECT * from user where id = ?"));
            getPs().setInt(1, userId);
            setRs(getPs().executeQuery());
            while (BaseDao.getRs().next()) {
               getUser = new User(getRs().getInt("id"),getRs().getString("firstname"),getRs().getString("lastname"),getRs().getString("address"),getRs().getString("role"),getRs().getString("password"),getRs().getString("salt"),getRs().getString("image"));
            }
            disconnect();
            return getUser;

        } catch (SQLException e) {
            throw new DaoException(UserDao.class.getName(),"create",e.getMessage(),"Une erreur s'est produite lors de la récupération de l'utilisateur");
        }
    }


}
