package eu.ensup.myresto;

/**
 * The type Category mapper.
 */
public class CategoryMapper {

    /**
     * Instantiates a new Category mapper.
     */
    CategoryMapper() {
        throw new IllegalStateException("Mapper Class");
    }

    /**
     * Convert domaine dto category dto.
     *
     * @param category the category
     * @return the category dto
     */
    public static CategoryDto convertDomaineDto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getImage());
    }

    /**
     * Convert dto domaine category.
     *
     * @param category the category
     * @return the category
     */
    public static Category convertDtoDomaine(CategoryDto category) {
        return new Category(category.getId(), category.getName(), category.getImage());
    }
}