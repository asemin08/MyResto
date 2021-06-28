package eu.ensup.myresto.mapper;

import Category;
import CategoryDto;

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