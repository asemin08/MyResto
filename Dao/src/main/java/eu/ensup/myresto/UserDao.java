package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao extends BaseDao implements IUserDao {
    private static final Logger log = LogManager.getLogger(UserDao.class);

    @Override
    public int create(User user) throws DaoException {

        try {
            connexion();
            setPs(getCn().prepareStatement("INSERT INTO user(login,firstname,lastname,address,role,password,salt,image) VALUES(?,?,?,?,?,?,?,?) "));
            getPs().setString(1,user.getLogin());
            getPs().setString(2, user.getFirstName());
            getPs().setString(3, user.getLastName());
            getPs().setString(4, user.getAddress());
            getPs().setString(5, user.getRole());
            getPs().setString(6, user.getPassword());
            getPs().setString(7, user.getSalt());
            getPs().setString(8, user.getImage());
            setResult(getPs().executeUpdate());
            disconnect();
            return BaseDao.getResult();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DaoException(UserDao.class.getName(),"create",e.getMessage(),"Une erreur s'est produite lors de la création de l'utilisateur");
        }
    }

    @Override

    public int update(User user) throws DaoException  {
        try {
            connexion();
            setPs(getCn().prepareStatement("UPDATE user SET firstname = ?, lastname = ?, address = ?, role = ?, image = ? where id = ?"));
            getPs().setString(1, user.getFirstName());
            getPs().setString(2, user.getLastName());
            getPs().setString(3, user.getAddress());
            getPs().setString(4, user.getRole());
            getPs().setString(5, user.getImage());
            getPs().setInt(6, user.getId());
            setResult(getPs().executeUpdate());
            disconnect();
            return getResult();
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DaoException(UserDao.class.getName(),"update",e.getMessage(),"Une erreur s'est produite lors de la mise à jour d'utilisateur");
        }
    }

    @Override
    public int delete(int userId)throws DaoException  {
        try {
            connexion();
            setPs(getCn().prepareStatement("delete from user where id = ?"));
            getPs().setInt(1, userId);
            setResult(getPs().executeUpdate());
            disconnect();
            return getResult();
        } catch (SQLException | DaoException e) {
            log.error(e.getMessage());
            throw new DaoException(UserDao.class.getName(),"delete",e.getMessage(),"Une erreur s'est produite lors de la suppression de l'utilisateur");
        }
    }


    @Override
    public User getById(int userId) throws DaoException {
        User getUser = null;
        try {
            connexion();
            setPs(getCn().prepareStatement("SELECT * from user where id = ?"));
            getPs().setInt(1, userId);
            setRs(getPs().executeQuery());
            while (BaseDao.getRs().next()) {
                getUser = new User(getRs().getInt("id"),getRs().getString("login"),getRs().getString("firstname"),getRs().getString("lastname"),getRs().getString("address"),getRs().getString("role"),getRs().getString("password"),getRs().getString("salt"),getRs().getString("image"));
            }
            disconnect();
            return getUser;

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DaoException(UserDao.class.getName(),"getById",e.getMessage(),"Une erreur s'est produite lors de la récupération de l'utilisateur");
        }
    }

    public User getByLogin(String login) throws DaoException {
        User getUser = null;
        try {
            connexion();
            setPs(getCn().prepareStatement("SELECT * from user where login = ?"));
            getPs().setString(1, login);
            setRs(getPs().executeQuery());
            while (BaseDao.getRs().next()) {
                getUser = new User(getRs().getInt("id"),getRs().getString("login"),getRs().getString("firstname"),getRs().getString("lastname"),getRs().getString("address"),getRs().getString("role"),getRs().getString("password"),getRs().getString("salt"),getRs().getString("image"));
            }
            disconnect();
            return getUser;

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new DaoException(UserDao.class.getName(),"getByLogin",e.getMessage(),"Une erreur s'est produite lors de la récupération de l'utilisateur");
        }
    }


}