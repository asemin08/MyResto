package eu.ensup.myresto;

import eu.ensup.myresto.CategoryDto;
import eu.ensup.myresto.exceptions.ServiceException;

import java.util.List;

public interface ICategoryService
{
    public List<CategoryDto> getAll() throws ServiceException;
    public CategoryDto get(int idCategory) throws ServiceException;
    public CategoryDto get(String nameCategory) throws ServiceException;

    public int create(CategoryDto category) throws ServiceException;
    public int update(CategoryDto category) throws ServiceException;
    public int delete(CategoryDto category) throws ServiceException;
    public int delete(int idCategory) throws ServiceException;
}
