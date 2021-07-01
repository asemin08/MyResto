package eu.ensup.myresto;

import java.sql.Date;
import java.util.List;

/**
 * The type Order product.
 */
public class OrderProduct {

    private Integer id;
    private int idUser;
    private List<Integer> idProduct;
    private String status;
    private Date dateCreated;

    /**
     * The enum Status.
     */
    public enum Status {
        /**
         * New status.
         */
        NEW,
        /**
         * Send status.
         */
        SEND,
        /**
         * Close status.
         */
        CLOSE
    }

    /**
     * Instantiates a new Order product.
     *
     * @param id          the id
     * @param idUser      the id user
     * @param idProduct   the id product
     * @param dateCreated the date created
     * @param status      the status
     */
    public OrderProduct(Integer id, int idUser, List<Integer> idProduct, Date dateCreated, String status) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    /**
     * Instantiates a new Order product.
     *
     * @param idUser      the id user
     * @param idProduct   the id product
     * @param status      the status
     * @param dateCreated the date created
     */
    public OrderProduct(int idUser, List<Integer> idProduct, String status, Date dateCreated) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.status = status;
        this.dateCreated = dateCreated;
    }


    /**
     * Instantiates a new Order product.
     *
     * @param idUser      the id user
     * @param idProduct   the id product
     * @param dateCreated the date created
     */
    public OrderProduct(int idUser, List<Integer> idProduct, Date dateCreated) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.dateCreated = dateCreated;
        this.status = Status.NEW.toString();
    }

    /**
     * Instantiates a new Order product.
     *
     * @param id          the id
     * @param idUser      the id user
     * @param idProduct   the id product
     * @param dateCreated the date created
     */
    public OrderProduct(Integer id, int idUser, List<Integer> idProduct, Date dateCreated) {
        this.id = id;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.dateCreated = dateCreated;
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
     * Gets id user.
     *
     * @return the id user
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets id user.
     *
     * @param idUser the id user
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets id product.
     *
     * @return the id product
     */
    public List<Integer> getIdProduct() {
        return idProduct;
    }

    /**
     * Sets id product.
     *
     * @param idProduct the id product
     */
    public void setIdProduct(List<Integer> idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets date created.
     *
     * @return the date created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public String toString() {
        return "eu.ensup.myresto.OrderProduct{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idProduct=" + idProduct +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

}
