package eu.ensup.myresto.mapper;

import eu.ensup.myresto.domaine.Category;
import eu.ensup.myresto.dto.CategoryDto;

public class CategoryMapper
{
    public static CategoryDto convertDomaineDto(Category category)
    {
        return new CategoryDto(category.getId(), category.getName(), category.getImage());
    }
    public static Category convertDtoDomaine(CategoryDto category)
    {
        return new Category(category.getId(), category.getName(), category.getImage());
    }
}