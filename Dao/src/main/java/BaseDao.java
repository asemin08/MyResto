import exceptions.DaoException;

import java.sql.*;
import java.util.ResourceBundle;

public class BaseDao {

    private final String url;
    private final String login;
    private final String password;
    private static Connection cn = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    private static PreparedStatement ps = null;

    private static CallableStatement cs = null;

    private  static int result;

    /**
     * Instantiates a new Base dao.
     */
    public BaseDao() {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        this.url ="jdbc:mysql://localhost:3306/myresto?serverTimezone=Europe/Berlin" ;//bundle.getString("jdbc:mysql://localhost:3306/myresto?serverTimezone=Europe/Berlin");
        this.login = "root"; //bundle.getString("root");
        this.password =""; //bundle.getString("");
    }

    public int connexion() throws DaoException
    {
        try {
            cn = DriverManager.getConnection(url, login, password);
            st = cn.createStatement();
            System.out.println("Vous êtes connecter");
            return 0;
        }
        catch (SQLException e) {
            return 1;
        }
    }
    public void disconnect() throws DaoException
    {
        try {
            if( rs != null )
                rs.close();
            if( cs != null )
                cs.close();
            if( ps != null )
                ps.close();
            if( st != null )
                st.close();
            if( cn != null )
                cn.close();
        }
        catch (SQLException e) {

        }
    }
    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static Connection getCn() {
        return cn;
    }

    public static void setCn(Connection cn) {
        BaseDao.cn = cn;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement st) {
        BaseDao.st = st;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public static void setRs(ResultSet rs) {
        BaseDao.rs = rs;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static void setPs(PreparedStatement ps) {
        BaseDao.ps = ps;
    }

    public static CallableStatement getCs() {
        return cs;
    }

    public static void setCs(CallableStatement cs) {
        BaseDao.cs = cs;
    }

    public static int getResult() {
        return result;
    }

    public static void setResult(int result) {
        BaseDao.result = result;
    }
}