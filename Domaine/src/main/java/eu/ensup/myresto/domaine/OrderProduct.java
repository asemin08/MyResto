package eu.ensup.myresto.domaine;

public class OrderProduct
{
    private Integer id;
    private int idUser;
    private int idProduct;

    public OrderProduct(int id, int idUser, int idProduct)
    {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                '}';
    }
}
