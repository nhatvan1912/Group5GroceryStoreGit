package App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;


public class cardProductController implements Initializable {

    @FXML
    private AnchorPane card_form;

    @FXML
    private Button prod_addBtn;

    @FXML
    private ImageView prod_imagineView;

    @FXML
    private Label prod_name;

    @FXML
    private Label prod_price;

    @FXML
    private Spinner<Integer> prod_spinner;

    private productData prodData;
    private Image image;

    private SpinnerValueFactory<Integer> spin;

    private String prodID;
    private String type;
    private String prod_date;
    private String prod_image;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;
    public static String username;
    public void setData(productData prodData)
    {
        this.prodData = prodData;
        prod_image = prodData.getImage();
        prod_date = String.valueOf(prodData.getDate());
        type = prodData.getType();
        prodID = prodData.getProductID();
        prod_name.setText(prodData.getProductName());
        prod_price.setText(String.valueOf(prodData.getPrice()) + " VNĐ");
        String path = "File:" + prodData.getImage();
        image = new Image(path, 190, 105, false, true);
        prod_imagineView.setImage(image);
        pr = prodData.getPrice();
    }

    private int qty;

    public void setQuantity()
    {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        prod_spinner.setValueFactory(spin);
    }

    private int totalP;
    private int pr;
    private MainInterfaceController mainController;

    public void setMainController(MainInterfaceController mainController) {
        this.mainController = mainController;
    }

    public void addBtn() {


        qty = prod_spinner.getValue();
        String check = "";
        String checkAvailable = "SELECT status FROM product WHERE prod_id =  '" + prodID + "'";

        connect = Database.connectDB();

        if (!mainController.isCheckPrintReceipt()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Printing receipt before adding new product");
            alert.showAndWait();
            spin.setValue(0);
        }
        else {
//            mainController.customerID();
            try {
                int checkStck = 0;
                String checkStock = "SELECT stock FROM product WHERE prod_id = '"
                        + prodID + "'";
                prepare = connect.prepareStatement(checkStock);
                result = prepare.executeQuery();

                if (result.next()) {
                    checkStck = result.getInt("stock");
                }

                if (checkStck == 0) {
                    String updateStock = "UPDATE product SET prod_name = '"
                            + prod_name.getText() + "', type = '"
                            + type + "', stock = 0, price = "
                            + pr + ", status = 'Unavailable', image = '"
                            + prod_image + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prodID + "'";

                    prepare = connect.prepareStatement(updateStock);
                    prepare.executeUpdate();
                }

                prepare = connect.prepareStatement(checkAvailable);
                result = prepare.executeQuery();

                if (result.next()) {
                    check = result.getString("status");
                }

                if (check.equals("Unavailable") || qty == 0) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Something Wrong");
                    alert.showAndWait();
                } else {
                    checkStck = 0;
                    prepare = connect.prepareStatement(checkStock);
                    result = prepare.executeQuery();
                    if (result.next()) {
                        checkStck = result.getInt("stock");
                    }
                    if (checkStck < qty) {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid. This product is Out of stock");
                        alert.showAndWait();
                    } else {
                        String insertData = "INSERT INTO customer "
                                + "(customer_id, prod_name, quantity, price, date, em_username)"
                                + "VALUES(?, ?, ?, ?, ?, ?)";
                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, String.valueOf(data.cID));
                        prepare.setString(2, prod_name.getText());
                        prepare.setString(3, String.valueOf(qty));
                        totalP = (qty * pr);
                        prepare.setString(4, String.valueOf(totalP));
                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setString(5, String.valueOf(sqlDate));
                        prepare.setString(6, data.username);
                        prepare.executeUpdate();

                        int upStock = checkStck - qty;

                        prod_image = prod_image.replace("\\", "\\\\");

                        String updateStock = "UPDATE product SET prod_name = '"
                                + prod_name.getText() + "', type = '"
                                + type + "', stock = "
                                + upStock + ", price = "
                                + pr + ", status = '"
                                + check + "', image = '"
                                + prod_image + "', date = '"
                                + prod_date + "' WHERE prod_id = '"
                                + prodID + "'";

                        prepare = connect.prepareStatement(updateStock);
                        prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();
                        spin.setValue(0);
                        mainController.menuShowTotal();
                        mainController.menuShowOrderData();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuantity();
    }
}
