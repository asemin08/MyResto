package eu.ensup.myresto;

public class CategoryMapper {

    CategoryMapper() {
        throw new IllegalStateException("Mapper Class");
    }

    public static CategoryDto convertDomaineDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getImage());
    }

    public static Category convertDtoDomaine(CategoryDto category) {
        return new Category(category.getId(), category.getName(), category.getImage());
    }
}