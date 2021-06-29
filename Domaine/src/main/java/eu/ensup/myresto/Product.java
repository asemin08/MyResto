package eu.ensup.myresto;

public class Product {
    private int id;
    private String name;
    private float price;
    private String picture;
    private String description;
    private int idCategory;

    public Product(int id, String name, float price, String picture, String description, int idCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product(String name, float price, String picture, String description, int idCategory) {
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.description = description;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "eu.ensup.myresto.Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", idCategory=" + idCategory +
                '}';
    }
}
