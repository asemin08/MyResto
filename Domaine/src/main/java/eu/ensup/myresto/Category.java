package eu.ensup.myresto;

/**
 * The type Category.
 */
public class Category {
    private Integer id;
    private String name;
    private String image;

    /**
     * Instantiates a new Category.
     *
     * @param id    the id
     * @param name  the name
     * @param image the image
     */
    public Category(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets image.
     *
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "eu.ensup.myresto.Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
