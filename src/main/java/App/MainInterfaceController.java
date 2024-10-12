package App;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.* ;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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

    public void inventoryAddBtn(){
        if(inventory_productID.getText().isEmpty()
            || inventory_productName.getText().isEmpty()
            || inventory_price.getText().isEmpty()
            || inventory_stock.getText().isEmpty()
            || inventory_type.getSelectionModel().getSelectedItem() == null
            || inventory_status.getSelectionModel().getSelectedItem() == null
            || path == ""){
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
                    String pathTemp = path.replace("/", "//");
                    prepare.setString(7, pathTemp);
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
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
                || path == "" || id == 0){
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
                || path == "" || id == 0){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select product you want to update!");
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
        path = "File:" + prodData.getImage();
        date = String.valueOf(prodData.getDate());
        id = prodData.getId();
        image = new Image(path, 130, 140, true, true);
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
                        , result.getDouble("price")
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

    private String[] TypeList = {"Vegetable", "Beverages", "Food", "Seafood", "Meat",
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
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        inventoryTypeList();
        inventoryStatusList();
        inventoryShowData();
    }
}
