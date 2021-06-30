package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.DaoException;

import java.util.List;

public interface ICategoryDao {
    List<Category> getAll() throws DaoException;

    Category getById(int idCategory) throws DaoException;

    Category getByName(String nameCategory) throws DaoException;

    int create(Category category) throws DaoException;

    int update(Category category) throws DaoException;

    int delete(Category category) throws DaoException;

    int delete(int idCategory) throws DaoException;
}
