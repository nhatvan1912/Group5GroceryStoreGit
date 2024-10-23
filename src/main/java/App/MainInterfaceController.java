package App;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.* ;
import java.util.Date;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.*;


public class MainInterfaceController implements Initializable {
    @FXML
    private Button customers_btn;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button inventory_addBtn;

    @FXML
    private Button inventory_btn;

    @FXML
    private Button inventory_clearBtn;

    @FXML
    private TableColumn<productData, String> inventory_col_date;

    @FXML
    private TableColumn<productData, String> inventory_col_productID;

    @FXML
    private TableColumn<productData, String> inventory_col_productName;

    @FXML
    private TableColumn<productData, String> inventory_col_price;

    @FXML
    private TableColumn<productData, String> inventory_col_status;

    @FXML
    private TableColumn<productData, String> inventory_col_stock;

    @FXML
    private TableColumn<productData, String> inventory_col_type;

    @FXML
    private Button inventory_deleteBtn;

    @FXML
    private AnchorPane inventory_form;

    @FXML
    private ImageView inventory_imageView;

    @FXML
    private Button inventory_importImage;

    @FXML
    private TableView<productData> inventory_table;

    @FXML
    private Button inventory_updateBtn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane mainInterface;

    @FXML
    private Button menu_btn;

    @FXML
    private Label main_username;

    @FXML
    private TextField inventory_price;

    @FXML
    private TextField inventory_productID;

    @FXML
    private TextField inventory_productName;

    @FXML
    private ComboBox<String> inventory_status;

    @FXML
    private TextField inventory_stock;

    @FXML
    private ComboBox<String> inventory_type;

    @FXML
    private TextField menu_amount;

    @FXML
    private Label menu_change;

    @FXML
    private TableColumn<productData, String> menu_col_price;

    @FXML
    private TableColumn<productData, String> menu_col_productName;

    @FXML
    private TableColumn<productData, Integer> menu_col_quantity;

    @FXML
    private AnchorPane menu_form;

    @FXML
    private GridPane menu_gridPane;

    @FXML
    private Button menu_payBtn;

    @FXML
    private Button menu_receiptBtn;

    @FXML
    private Button menu_removeBtn;

    @FXML
    private ScrollPane menu_scrollPane;

    @FXML
    private TableColumn<customerData, String> customers_col_cashier;

    @FXML
    private TableColumn<customerData, String> customers_col_customerID;

    @FXML
    private TableColumn<customerData, String> customers_col_date;

    @FXML
    private TableColumn<customerData, String> customers_col_total;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private TableView<productData> menu_tableView;

    @FXML
    private Label menu_total;

    @FXML
    private Label dashboard_NC;

    @FXML
    private Label dashboard_NSP;

    @FXML
    private Label dashboard_TI;

    @FXML
    private Label dashboard_TotalI;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private BarChart<?, ?> dashboard_customerChart;


    @FXML
    private AreaChart<?, ?> dashboard_incomeChart;

    @FXML
    private FontAwesomeIcon inventory_lockIcon;


    public static String username;
    public static String path = "";
    public static String date;
    public static Integer id;
    private Image image;
    private Alert alert;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private ObservableList<productData> cardListData = FXCollections.observableArrayList();
    private System JRXmlLoader;

    public void dashboardDisplayNC(){

        String sql = "SELECT COUNT(id) FROM receipt";
        connect = Database.connectDB();

        try{
            int nc = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                nc = result.getInt("COUNT(id)");
            }
            dashboard_NC.setText(String.valueOf(nc));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTI(){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(total) FROM receipt WHERE date = '"
         + sqlDate + "'";

        connect = Database.connectDB();

        try{
            Integer ti = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result.next()){
                ti = result.getInt("SUM(total)");
            }
            dashboard_TI.setText("$" + ti);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public void dashboardTotalI(){

        String sql = "SELECT SUM(total) FROM receipt";

        connect = Database.connectDB();

        try{
            Integer ti = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result.next()){
                ti = result.getInt("SUM(total)");
            }
            dashboard_TotalI.setText("$" + ti);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dashboardNSP(){
        String sql = "SELECT COUNT(quantity) FROM customer";

        connect = Database.connectDB();

        try{
            int q = 0;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if(result.next()){
                q = result.getInt("COUNT(quantity)");

            }
            dashboard_NSP.setText(String.valueOf(q));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dashboardIncomeChart(){
        dashboard_incomeChart.getData().clear();
        String sql = "SELECT date, SUM(total) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            XYChart.Series chart = new XYChart.Series();
            while(result.next()){
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));

            }
            dashboard_incomeChart.getData().add(chart);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void dashboardCustomerChart(){
        dashboard_customerChart.getData().clear();
        String sql = "SELECT date, COUNT(id) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            XYChart.Series chart = new XYChart.Series();
            while(result.next()){
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));

            }
            dashboard_customerChart.getData().add(chart);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void inventoryAddBtn(){
        if(inventory_productID.getText().isEmpty()
            || inventory_productName.getText().isEmpty()
            || inventory_price.getText().isEmpty()
            || inventory_stock.getText().isEmpty()
            || inventory_type.getSelectionModel().getSelectedItem() == null
            || inventory_status.getSelectionModel().getSelectedItem() == null
            || path.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else{
            String checkProdID = "select prod_id from product where prod_id = '"
                    + inventory_productID.getText() + "'";
            connect = Database.connectDB();
            try{
                statement = connect.createStatement();
                result = statement.executeQuery(checkProdID);
                if(result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(inventory_productID.getText() + " is aldready taken");
                    alert.showAndWait();
                } else{
                    String addData = "insert into product "
                            + "(prod_id, prod_name, type, stock, price, status, image, date) "
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                    prepare = connect.prepareStatement(addData);
                    prepare.setString(1, inventory_productID.getText());
                    prepare.setString(2, inventory_productName.getText());
                    prepare.setString(3, inventory_type.getSelectionModel().getSelectedItem().toString());
                    prepare.setString(4, inventory_stock.getText());
                    prepare.setString(5, inventory_price.getText());
                    prepare.setString(6, inventory_status.getSelectionModel().getSelectedItem().toString());
                    String pathTemp = path.replace("\\", "\\\\");
                    prepare.setString(7, pathTemp);
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added!");
                    alert.showAndWait();

                    inventoryShowData();
                    inventoryClearBtn();
                }
            }catch(SQLException e){e.printStackTrace();}
        }
    }

    public void inventoryUpdateBtn(){
        if(inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_stock.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || path.isEmpty() || id == 0){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select product you want to update!");
            alert.showAndWait();
        }else{
            String pathTemp = path;
            pathTemp = pathTemp.replace("\\", "\\\\");
            String updateData = "update product set prod_id = '"
                    + inventory_productID.getText() + "', prod_name = '"
                    + inventory_productName.getText() + "', type = '"
                    + inventory_type.getSelectionModel().getSelectedItem().toString()
                    + "', stock = '" + inventory_stock.getText() + "', price = '"
                    + inventory_price.getText() + "', status = '"
                    + inventory_status.getSelectionModel().getSelectedItem().toString()
                    + "', image = '" + pathTemp + "', date = '" + date
                    + "' where id = " + id ;
            connect = Database.connectDB();
            try{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you want to update this product id: " + inventory_productID.getText());
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get() == ButtonType.OK){
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    inventoryShowData();
                    inventoryClearBtn();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            } catch(SQLException e){e.printStackTrace();}
        }
    }

    public void inventoryClearBtn(){
        inventory_productID.setText("");
        inventory_productName.setText("");
        inventory_price.setText("");
        inventory_stock.setText("");
        inventory_type.getSelectionModel().clearSelection();
        inventory_status.getSelectionModel().clearSelection();
        path = "";
        inventory_imageView.setImage(null);
        id = 0;
    }

    public void inventoryDeleteBtn(){
        if(inventory_productID.getText().isEmpty()
                || inventory_productName.getText().isEmpty()
                || inventory_price.getText().isEmpty()
                || inventory_stock.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null
                || inventory_status.getSelectionModel().getSelectedItem() == null
                || path.isEmpty() || id == 0){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select product you want to delete!");
            alert.showAndWait();
        }else {
            String deleteData = "delete from product where id = " + id;
            connect = Database.connectDB();
            try{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure to delete " + inventory_productName.getText());
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get() == ButtonType.OK){
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete!");
                    alert.showAndWait();

                    inventoryShowData();
                    inventoryClearBtn();
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                }
            } catch(SQLException e){e.printStackTrace();}
        }
    }

    public void importImageBtn(){
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg"));
        File file = openFile.showOpenDialog(mainInterface.getScene().getWindow());
        if(file != null){
            path = file.getAbsolutePath();
            image = new Image(file.toURI().toString(), 130, 140, true, true);
            inventory_imageView.setImage(image);
        }
    }

    public void inventorySelectData(){
        productData prodData = inventory_table.getSelectionModel().getSelectedItem();
        int num = inventory_table.getSelectionModel().getSelectedIndex();
        if(num < 0) return;
        inventory_productID.setText(prodData.getProductID());
        inventory_productName.setText(prodData.getProductName());
        inventory_stock.setText(String.valueOf(prodData.getStock()));
        inventory_price.setText(String.valueOf(prodData.getPrice()));
        inventory_type.getSelectionModel().select(prodData.getType());
        inventory_status.getSelectionModel().select(prodData.getStatus());
        String pathTemp = prodData.getImage();
        path = pathTemp.replace("\\\\","\\");
        date = String.valueOf(prodData.getDate());
        id = prodData.getId();
        image = new Image(pathTemp, 130, 140, true, true);
        inventory_imageView.setImage(image);
    }

    public ObservableList<productData> inventoryDataList(){
        ObservableList<productData> listData = FXCollections.observableArrayList();
        String table = "select * from product";
        connect = Database.connectDB();
        try{
            prepare = connect.prepareStatement(table);
            result = prepare.executeQuery();
            productData prodData;
            while(result.next()){
                prodData = new productData(result.getInt("id")
                        , result.getString("prod_id")
                        , result.getString("prod_name")
                        , result.getString("type")
                        , result.getInt("stock")
                        , result.getInt("price")
                        , result.getString("status")
                        , result.getString("image")
                        , result.getDate("date"));
                listData.add(prodData);
            }
        }catch(SQLException e){e.printStackTrace();}
        return listData;
    }

    private ObservableList<productData> inventoryListData;
    public void inventoryShowData(){
        inventoryListData = inventoryDataList();
        inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productID"));
        inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        inventory_table.setItems(inventoryListData);
    }

    private String[] TypeList = {"Vegetable", "Beverages", "Fast food", "Seafood", "Meat",
    "Consumer Goods", "Personal Care"};
    public void inventoryTypeList(){
        List<String> typeList = new ArrayList<>();
        Collections.addAll(typeList, TypeList);
        ObservableList listData = FXCollections.observableArrayList(typeList);
        inventory_type.setItems(listData);
    }

    private String[] StatusList = {"Available", "Unavailable"};
    public void inventoryStatusList(){
        List<String> statusList = new ArrayList<>();
        Collections.addAll(statusList, StatusList);
        ObservableList listData = FXCollections.observableArrayList(statusList);
        inventory_status.setItems(listData);
    }

    public ObservableList<productData> menuGetData()
    {

        String sql = "SELECT * FROM product";

        ObservableList<productData> listData = FXCollections.observableArrayList();
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            productData prod;

            while (result.next())
            {
                prod = new productData(result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getString("type"),
                        result.getInt("stock"),
                        result.getInt("price"),
                        result.getString("image"),
                        result.getDate("date"));

                listData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    public void menuDisplayCard()
    {
        cardListData.clear();
        cardListData.addAll(menuGetData());

        int row = 0, column = 0;

        menu_gridPane.getChildren().clear();
        menu_gridPane.getRowConstraints().clear();
        menu_gridPane.getColumnConstraints().clear();

        for (int q = 0; q < cardListData.size(); q++)
        {
            try{
                FXMLLoader load = new FXMLLoader();
                load.setLocation(getClass().getResource("cardProduct.fxml"));
                AnchorPane pane = load.load();
                cardProductController cardC = load.getController();
                cardC.setMainController(this);
                cardC.setData(cardListData.get(q));

                if (column == 4){
                    column = 0;
                    row += 1;
                }

                menu_gridPane.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<productData> menuGetOrder()
    {
        customerID();
        ObservableList<productData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer WHERE customer_id = '" + cID + "'";
        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            productData prod;
            while (result.next())
            {
                prod = new productData(result.getInt("id"),
                        result.getString("prod_name"),
                        result.getInt("quantity"),
                        result.getInt("price"),
                        result.getDate("date"));
                listData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<productData> menuOrderListData;
    public void menuShowOrderData()
    {
        menuOrderListData = menuGetOrder();
        menu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        menu_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        menu_tableView.setItems(menuOrderListData);
    }

    private int totalP;
    public void menuGetTotal(){
//        customerID();
        String total = "SELECT SUM(price) FROM customer WHERE customer_id = '"
                + cID + "'";

        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();

            if (result.next())
            {
                totalP = result.getInt("SUM(price)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menuShowTotal()
    {
        menuGetTotal();
        menu_total.setText(totalP + " VNĐ");
    }

    private int amount, change = 0;
    public void menuAmount()
    {
//        menuGetTotal();
        if (menu_amount.getText().isEmpty())
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Amount is empty");
            alert.showAndWait();
            menu_change.setText("");
        }
        else{
            amount = Integer.parseInt(menu_amount.getText());
            change = amount - totalP;
            menu_change.setText(change + " VNĐ");
        }
    }

    public boolean checkPrintReceipt = true, checkPay = false;
    public void menuPayBtn()
    {
        if (checkPay)
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please print receipt before paying others");
            alert.showAndWait();
        }
        else {
            menuAmount();
            if (totalP == 0)
            {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please choose product");
                alert.showAndWait();
                menu_change.setText("");
            }
            else if (!menu_amount.getText().isEmpty())
            {
                String insertPay = "INSERT INTO receipt (customer_id, total, date, em_username)"
                        + "VALUES( ?, ?, ?, ?)";

                connect = Database.connectDB();

                try {
                    alert = new Alert((Alert.AlertType.CONFIRMATION));
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Are your sure?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.get().equals(ButtonType.OK)) {

                        prepare = connect.prepareStatement(insertPay);

                        change = amount - totalP;
                        if (change < 0) {
                            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Don't enough money to pay");
                            alert.showAndWait();

                        } else {

                            prepare.setString(1, String.valueOf(cID));
                            prepare.setString(2, String.valueOf(totalP));
                            Date date = new Date();
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            prepare.setString(3, String.valueOf(sqlDate));
                            prepare.setString(4, data.username);

                            prepare.executeUpdate();

                            alert = new Alert((AlertType.INFORMATION));
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Pay successfully");
                            alert.showAndWait();
                            alert.setContentText("Remember print receipt for customer before paying others");
                            alert.showAndWait();
                            checkPay = true;
                            checkPrintReceipt = false;
                        }
                    }
                    else{
                        alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled");
                        alert.showAndWait();
                    }
                }
                catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private int getid;
    public void menuSelectOrder()
    {
        productData prod = menu_tableView.getSelectionModel().getSelectedItem();
        int num = menu_tableView.getSelectionModel().getSelectedIndex();

        if ((num -1) < -1) return;

        getid = prod.getId();
    }

    public void menuRemoveBtn(){
        menuSelectOrder();
        if (getid == 0)
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the order you want to remove");
            alert.showAndWait();
        }
        else {
            String deleteData = "DELETE FROM customer WHERE id = '" + getid + "'";
            connect = Database.connectDB();
            try{
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you want to delete this order");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                    menuShowTotal();
                    menuShowOrderData();
                }
                else{
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int cID;
    public void customerID()
    {

        String sql = "SELECT MAX(customer_id) FROM customer";
        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next())
            {
                cID = result.getInt("MAX(customer_id)");
            }

            String checkCID = "SELECT MAX(customer_id) FROM receipt";
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next())
            {
                checkID = result.getInt("MAX(customer_id)");
            }

            if (cID == 0 || cID == checkID)
                cID++;

            data.cID = cID;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(){
        try{
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get().equals(ButtonType.OK)){
                logout_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("loginGUI.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Group 5 Grocery Store");
                stage.setMinHeight(450);
                stage.setMaxHeight(670);
                stage.show();
            }
        }catch(Exception e){e.printStackTrace();}
    }
    public void displayUsername(){
        String user = username;
        user = user.substring(0,1).toUpperCase() + user.substring(1);
        main_username.setText(user);
        connect = Database.connectDB();
        String checkManager = "select manager from employee where username = '" + username + "'";
        try{
            prepare = connect.prepareStatement(checkManager);
            result = prepare.executeQuery();
            int isManager=0;
            if(result.next())
            {
                isManager=result.getInt("manager");
                if(isManager==1)
                {
                    inventory_lockIcon.setVisible(false);
                    inventory_btn.setDisable(false);
                }
                else{
                    inventory_lockIcon.setVisible(true);
                    inventory_btn.setDisable(true);
                }
            }
        } catch (SQLException e){e.printStackTrace();}
    }
    public void menuRestart(){
        totalP = 0;
        change = 0;
        amount = 0;
        menu_total.setText(0 + " VNĐ");
        menu_amount.setText("");
        menu_change.setText(0 + " VNĐ");
    }

    public void menuReceiptBtn(){
        if(totalP == 0 || menu_amount.getText().isEmpty()){
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please order first");
            alert.showAndWait();
        }
        else if (checkPay == false)
        {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please paying before printing receipt");
            alert.showAndWait();
        }
        else {

            HashMap map = new HashMap();
            map.put("getReceipt", (cID));

            try {

                JasperReport jReport = JasperCompileManager.compileReport("D:\\Group5GroceryStoreGit\\src\\main\\resources\\App\\report.jrxml");
                JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);

                JasperViewer.viewReport(jPrint, false);

                menuRestart();
                menuShowOrderData();
                checkPrintReceipt = true;
                checkPay = false;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public boolean isCheckPrintReceipt(){
        boolean res = true;
        if (checkPrintReceipt == false) {
            res = false;
        }
        return res;
    }

    public ObservableList<customerData> customersDataList(){

        ObservableList<customerData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM receipt";
        connect = Database.connectDB();

        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            customerData cData;

            while(result.next()){
                cData = new customerData(result.getInt("id"), result.getInt("customer_id"),
                        result.getInt("total"), result.getDate("date"),
                        result.getString("em_username"));
                listData.add(cData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<customerData> customersListData;
    public void customersShowData(){
        customersListData = customersDataList();

        customers_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customers_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_cashier.setCellValueFactory(new PropertyValueFactory<>("emUsername"));

        customers_tableView.setItems(customersListData);

    }


    public void switchForm(ActionEvent event)
    {
        if (event.getSource() == dashboard_btn)
        {
            dashboard_form.setVisible(true);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);

            dashboardDisplayNC();
            dashboardDisplayTI();
            dashboardTotalI();
            dashboardNSP();
            dashboardIncomeChart();
            dashboardCustomerChart();

        }
        else if (event.getSource() == inventory_btn)
        {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(true);
            menu_form.setVisible(false);
            customers_form.setVisible(false);

            inventoryTypeList();
            inventoryStatusList();
            inventoryShowData();
        }
        else if (event.getSource() == menu_btn)
        {
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(true);
            customers_form.setVisible(false);

            menuDisplayCard();
            menuShowTotal();
            menuShowOrderData();
        }
        else if(event.getSource() == customers_btn){
            dashboard_form.setVisible(false);
            inventory_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(true);

            customersShowData();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();

        dashboardDisplayNC();
        dashboardDisplayTI();
        dashboardTotalI();
        dashboardNSP();
        dashboardIncomeChart();
        dashboardCustomerChart();

        inventoryTypeList();
        inventoryStatusList();
        inventoryShowData();

        menuDisplayCard();
        menuShowTotal();
        menuShowOrderData();

        customersShowData();
    }
}
