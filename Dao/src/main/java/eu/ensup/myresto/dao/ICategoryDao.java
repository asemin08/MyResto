package eu.ensup.myresto.dao;

import eu.ensup.myresto.domaine.Category;

import java.util.List;

public interface ICategoryDao
{
    public List<Category> getAll();
    public Category get(int idCategory);
    public Category get(String nameCategory);

    public boolean create(Category category);
    public boolean update(Category category);
    public boolean delete(Category category);
    public boolean delete(int idCategory);
}
