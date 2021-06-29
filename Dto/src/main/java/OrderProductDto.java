import java.sql.Date;
import java.util.List;

public class OrderProductDto {
    private Integer id;
    private int idUser;
    private List<Integer> idProduct;
    private String status;
    private Date dateCreated;

    public enum Status {
        NEW, SEND, CLOSE
    }

    public OrderProductDto(Integer id, int idUser, List<Integer> idProduct, Date dateCreated, String status) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public OrderProductDto(int idUser, List<Integer> idProduct, String status, Date dateCreated) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.status = status;
        this.dateCreated = dateCreated;
    }


    public OrderProductDto(int idUser, List<Integer> idProduct, Date dateCreated) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.dateCreated = dateCreated;
        this.status = Status.NEW.toString();
    }

    public OrderProductDto(Integer id, int idUser, List<Integer> idProduct, Date dateCreated) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.dateCreated = dateCreated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<Integer> getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(List<Integer> idProduct) {
        this.idProduct = idProduct;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}