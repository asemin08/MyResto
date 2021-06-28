import exceptions.DaoException;

import java.util.List;

public interface ICategoryDao
{
    public List<Category> getAll() throws DaoException;
    public Category get(int idCategory) throws DaoException;
    public Category get(String nameCategory) throws DaoException;

    public int create(Category category) throws DaoException;
    public int update(Category category) throws DaoException;
    public int delete(Category category) throws DaoException;
    public int delete(int idCategory) throws DaoException;
}
