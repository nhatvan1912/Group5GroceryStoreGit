package App;

import java.util.Date;

public class customerData {
    private Integer id;
    private Integer customerID;
    private Integer total;
    private Date date;
    private String emUsername;

    public customerData(Integer id, Integer customerID, Integer total, Date date, String emUsername){
        this.id = id;
        this.customerID = customerID;
        this.total = total;
        this.date = date;
        this.emUsername = emUsername;
    }
    public Integer getId(){
        return id;
    }
    public Integer getCustomerID(){
        return customerID;
    }
    public Integer getTotal(){
        return total;
    }
    public Date getDate(){
        return date;
    }
    public String getEmUsername(){
        return emUsername;
    }
}


