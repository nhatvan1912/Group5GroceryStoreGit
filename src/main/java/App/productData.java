package App;

import java.sql.Date;

public class productData {
    private Integer id, stock;
    private String productID, productName, status, image, type;
    private Double price;
    private Date date;

    public productData(Integer id, String productID, String productName,
                       String type, Integer stock, Double price,
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
    public Double getPrice() {
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
