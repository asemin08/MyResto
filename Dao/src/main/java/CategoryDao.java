import eu.ensup.myresto.domaine.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao
{
    private BaseDao baseDao;

    public CategoryDao()
    {
        this.baseDao = new BaseDao();
        this.baseDao.connexion();
    }

    @Override
    public List<Category> getAll()
    {
        Connection cn = this.baseDao.getCn();
        List<Category> allCategory = new ArrayList<Category>();

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Category");
            if(!res.next()){
                System.out.println("Aucune category disponible dans la base de donnée.");
            }
            while( res.next() )
            {
                Category category = new Category(res.getInt("id"),res.getString("name"),res.getString("image"));

                allCategory.add(category);
            }

            // TODO:  Add logger failed and successfull
			if(allCategory.isEmpty())
			{
			    System.out.println("allCategory is empty");
            }
			else
            {
                System.out.println("allCategory is good");
            }
        }
        catch (SQLException e) {
            System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
            System.out.println("Un problème est survenu au niveau de la base de donnée.");
        }
        finally{
            try {
                if( st != null )
                    st.close();
            }
            catch(SQLException sqle) {
                System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
                System.out.println("Un problème est survenu au niveau de la base de donnée.");
            }
        }

        return allCategory;
    }

    @Override
    public Category get(int idCategory)
    {
        Connection cn = this.baseDao.getCn();
        Category category = null;

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Category Where id = "+idCategory);
            if(!res.next()){
                System.out.println("Aucune category disponible dans la base de donnée.");
            }

            while( res.next() )
            {
                category = new Category(res.getInt("id"),res.getString("name"),res.getString("image"));
            }

            // TODO:  Add logger failed and successfull
            if(category == null)
            {
                System.out.println("this object doesn't exist");
            }
            else
            {
                System.out.println("category is good");
            }
        }
        catch (SQLException e) {
            System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
            System.out.println("Un problème est survenu au niveau de la base de donnée.");
        }
        finally{
            try {
                if( st != null )
                    st.close();
            }
            catch(SQLException sqle) {
                System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
                System.out.println("Un problème est survenu au niveau de la base de donnée.");
            }
        }

        return category;
    }

    @Override
    public Category get(String nameCategory) {
        Connection cn = this.baseDao.getCn();
        Category category = null;

        Statement st = null;
        ResultSet res = null;
        try
        {
            st = cn.createStatement();
            res = st.executeQuery("SELECT * FROM Category Where name = "+nameCategory);
            if(!res.next()){
                System.out.println("Aucune category disponible dans la base de donnée.");
            }

            while( res.next() )
            {
                category = new Category(res.getInt("id"),res.getString("name"),res.getString("image"));
            }

            // TODO:  Add logger failed and successfull
            if(category == null)
            {
                System.out.println("this object doesn't exist");
            }
            else
            {
                System.out.println("category is good");
            }
        }
        catch (SQLException e) {
            System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
            System.out.println("Un problème est survenu au niveau de la base de donnée.");
        }
        finally{
            try {
                if( st != null )
                    st.close();
            }
            catch(SQLException sqle) {
                System.out.println("La transaction SELECT dans la méthode getAll a échouée.");
                System.out.println("Un problème est survenu au niveau de la base de donnée.");
            }
        }

        return category;
    }

    @Override
    public boolean create(Category category)
    {
        Connection cn = this.baseDao.getCn();

        PreparedStatement pstmt = null;
        try
        {
            //Vérifie qu'il n'y a pas de double
            if( get(category.getName()) == null )
            {
                if(category.getId() != -1)
                    pstmt = cn.prepareStatement("INSERT INTO Category (id, name, image) VALUES ( ?, ?, ? )");
                else
                    pstmt = cn.prepareStatement("INSERT INTO Category (name, image) VALUES ( ?, ? )");

                int index = 1;
                if(pstmt.getParameterMetaData().getParameterCount() == 3)
                    pstmt.setInt(index++, category.getId());

                pstmt.setString(index++, category.getName());
                pstmt.setString(index++, category.getImage());

                pstmt.execute();
                System.out.println("La "+category.toString()+" a bien été crée.");
            }
            else{
                System.out.println("La "+category.toString()+" existe déjà.");
            }
        }
        catch (SQLException e) {
            System.out.println("Un problème est survenu au niveau de la base de donnée.");
            return false;
        }
        finally{
            try {
                if( pstmt !=  null )
                    pstmt.close();
            }
            catch(SQLException sqle) {
                System.out.println("Un problème est survenu au niveau de la base de donnée.");
            }
            return true;
        }
    }

    @Override
    public boolean update(Category category) {
        Category preCategory = get(category.getId());
        String update = "";

        if( category.getName() != null && ! category.getName().equals(preCategory.getName()) )
            update += "name='"+category.getName()+"'";

        if( category.getImage() != null && category.getImage().equals(preCategory.getImage()) )
            update += (update != "" ? "," : "")+"image='"+category.getImage()+"'";

        if( update != "" )
        {
            Connection cn = this.baseDao.getCn();
            Statement st = null;
            try {
                st = cn.createStatement();
                st.execute("UPDATE Category SET "+update+" WHERE id="+category.getId());
            }
            catch( SQLException sqle) {
                // TODO:  Add logger failed and successfull
                return false;
            }
            finally {
                try {
                    if( st != null )
                        st.close();
                }
                catch (SQLException throwables) {

                    // TODO:  Add logger failed and successfull
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Category category)
    {
        if( category.getId() == null )
            return delete(get(category.getName()).getId());
        return delete(category.getId());
    }

    @Override
    public boolean delete(int idCategory) {
        if( idCategory != -1 && get(idCategory) != null )
        {
            Connection cn = this.baseDao.getCn();

            Statement st = null;
            try {
                st = cn.createStatement();
                st.execute("DELETE FROM Category WHERE id=" + idCategory);
                System.out.println("La suppression du cours a réussie.");
            } catch (SQLException e) {
                // TODO:  Add logger failed and successfull
                System.out.println("Un problème est survenu au niveau de la base de donnée.");
                return false;
            } finally {
                try {
                    if (st != null)
                        st.close();
                } catch (SQLException sqle) {
                    // TODO:  Add logger failed and successfull
                    System.out.println("Un problème est survenu au niveau de la base de donnée.");
                }
                return true;
            }
        }

        return false;
    }
}
