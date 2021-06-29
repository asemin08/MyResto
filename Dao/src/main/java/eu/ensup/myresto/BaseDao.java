package eu.ensup.myresto;

import java.sql.*;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseDao {

    private final String url;
    private final String login;
    private final String password;
    private Connection cn = null;
    private Statement st = null;
    private static ResultSet rs = null;

    private static PreparedStatement ps = null;

    private static CallableStatement cs = null;

    private static int result;
    private static final Logger log = LogManager.getLogger(BaseDao.class);

    /**
     * Instantiates a new Base dao.
     */
    public BaseDao() {
        var bundle = ResourceBundle.getBundle("db");
        this.url = bundle.getString("db.url");
        this.login = bundle.getString("db.username");
        this.password = bundle.getString("db.password");
    }

    public int connexion() {
        try {
            cn = DriverManager.getConnection(this.url, login, password);
            st = cn.createStatement();
            return 0;
        } catch (SQLException e) {
            log.error(e.getMessage());
            return 1;
        }
    }

    public void disconnect() {
        try {
            if (rs != null)
                rs.close();
            if (cs != null)
                cs.close();
            if (ps != null)
                ps.close();
            if (st != null)
                st.close();
            if (cn != null)
                cn.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
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

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public Statement getSt() {
        return this.st;
    }

    public void setSt(Statement st) {
        this.st = st;
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