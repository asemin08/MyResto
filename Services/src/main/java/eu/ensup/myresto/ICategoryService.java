package eu.ensup.myresto;

import eu.ensup.myresto.exceptions.ServiceException;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAll() throws ServiceException;

    CategoryDto getById(int idCategory) throws ServiceException;

    CategoryDto getByName(String nameCategory) throws ServiceException;

    int create(CategoryDto category) throws ServiceException;

    int update(CategoryDto category) throws ServiceException;

    int delete(CategoryDto category) throws ServiceException;

    int delete(int idCategory) throws ServiceException;
}
