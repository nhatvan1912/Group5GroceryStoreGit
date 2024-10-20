package App;

import java.sql.Date;

public class productData {
    private Integer id, stock, price, quantity;
    private String productID, productName, status, image, type;
    private Date date;

    public productData(Integer id, String productID, String productName,
                       String type, Integer stock, Integer price,
                       String status, String image, Date date) {
        this.id = id;
        this.stock = stock;
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.status = status;
        this.price = price;
        this.date = date;
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public productData(Integer id, String productID, String productName, String type, int quantity, Integer price, String image, Date date) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.image = image;
        this.date = date;
        this.quantity = quantity;
    }

    public productData(Integer id, String productName, Integer quantity, Integer price, Date date) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }
    public String getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public String getType() {
        return type;
    }
    public Integer getStock() {
        return stock;
    }
    public Integer getPrice() {
        return price;
    }
    public String getStatus() {
        return status;
    }
    public String getImage() {
        return image;
    }
    public Date getDate() {
        return date;
    }
}
