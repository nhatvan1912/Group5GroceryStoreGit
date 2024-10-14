package App;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LoginController {
    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private PasswordField fp_answer;

    @FXML
    private Button fp_changeBtn;

    @FXML
    private Button fp_confirmBtn;

    @FXML
    private PasswordField fp_confirmPassword;

    @FXML
    private AnchorPane fp_newPassForm;

    @FXML
    private PasswordField fp_newPassword;

    @FXML
    private TextField fp_username;

    @FXML
    private ComboBox<?> fp_question;

    @FXML
    private AnchorPane fp_questionForm;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginForm;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private Button site_aldreadyHave;

    @FXML
    private Button site_createBtn;

    @FXML
    private AnchorPane site_form;

    @FXML
    private PasswordField su_answer;

    @FXML
    private PasswordField su_password;

    @FXML
    private ComboBox<?> su_question;

    @FXML
    private Button su_signupBtn;

    @FXML
    private AnchorPane su_signupForm;

    @FXML
    private TextField su_username;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;

    public void loginBtn(){
        if(si_username.getText().isEmpty() || si_password.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else{
            String selectData = "select username from employee where username = ? and password = ?";
            connect = Database.connectDB();

            try{
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, si_username.getText());
                prepare.setString(2, si_password.getText());

                result = prepare.executeQuery();
                if(result.next()){
                    data.username = si_username.getText();
                    MainInterfaceController.username = si_username.getText();
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully logged in");
                    alert.showAndWait();

                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("mainInterface.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setTitle("Group 5 Grocery Store");
                        stage.setMinWidth(1100);
                        stage.setMinHeight(600);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    si_loginBtn.getScene().getWindow().hide();
                }else{
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect username or password");
                    alert.showAndWait();
                }
            }catch(SQLException e){e.printStackTrace();}
        }
    }
    public void registerBtn(){
        if(su_username.getText().isEmpty() || su_password.getText().isEmpty()
            || su_question.getSelectionModel().getSelectedItem() == null
            || su_answer.getText().isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else {
            String regData = "INSERT INTO employee (username, password, question, answer, date) "
                    + "VALUES (?,?,?,?,?)";
            connect = Database.connectDB();

            try {
                String checkUsername = "SELECT username FROM employee WHERE username = '"
                        + su_username.getText() + "'";
                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();

                if(result.next()){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(su_username.getText()+" is existed");
                    alert.showAndWait();
                }
                else if(su_password.getText().length() < 8)
                {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Password is too short");
                    alert.showAndWait();
                }
                else{
                    prepare = connect.prepareStatement(regData);
                    prepare.setString(1, su_username.getText());
                    prepare.setString(2, su_password.getText());
                    prepare.setString(3, (String)su_question.getSelectionModel().getSelectedItem());
                    prepare.setString(4, su_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Registered!");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");

                    TranslateTransition slider = new TranslateTransition();
                    slider.setNode(site_form);
                    slider.setDuration(Duration.seconds(0.5));
                    slider.setOnFinished((ActionEvent e) ->{
                        site_aldreadyHave.setVisible(false);
                        site_createBtn.setVisible(true);
                        su_signupForm.setVisible(false);
                        si_loginForm.setVisible(true);
                    });
                    slider.play();
                }
            }catch(SQLException e){e.printStackTrace();}
        }
    }


    private String[] questionList = {"What is your favorite color?", "What is your favourite food?", "What is your last 4 numbers of your number?"};
    public void callQuestionList(){
        List<String> listQ = new ArrayList<>();
        for(String data: questionList){
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        su_question.setItems(listData);
    }

    public void forgotQuestionList(){
        List<String> listQ = new ArrayList<>();
        for(String data: questionList){
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        fp_question.setItems(listData);
    }
    public void forgotPassword(){
        fp_questionForm.setVisible(true);
        si_loginForm.setVisible(false);
        forgotQuestionList();
    }
    public void confirmQuestionBtn(){
        if( fp_username.getText().isEmpty() || fp_answer.getText().isEmpty()
                || fp_question.getSelectionModel().getSelectedItem() == null){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else{
            String selectData = "select username from employee where username = ? and question = ? and answer = ?";
            connect = Database.connectDB();

            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, fp_username.getText());
                prepare.setString(2, (String)fp_question.getSelectionModel().getSelectedItem());
                prepare.setString(3, fp_answer.getText());

                result = prepare.executeQuery();
                if(result.next()){
                    fp_newPassForm.setVisible(true);
                    fp_questionForm.setVisible(false);
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Failed Confirm Question");
                    alert.showAndWait();
                }
            }catch(SQLException e) {e.printStackTrace();}
        }
    }

    public void changePassword(){
        if(fp_newPassword.getText().isEmpty() || fp_confirmPassword.getText().isEmpty() )
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else if(!fp_newPassword.getText().equals(fp_confirmPassword.getText())){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Confirm Passwords do not match");
            alert.showAndWait();
        }else{
            connect = Database.connectDB();
            try{
                String updatePass = "update employee set password = '"
                        +fp_newPassword.getText() + "' where username = '"
                        +fp_username.getText() + "'";

                prepare = connect.prepareStatement(updatePass);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully changed Password!");
                alert.showAndWait();

                si_loginForm.setVisible(true);
                fp_newPassForm.setVisible(false);

                fp_newPassword.setText("");
                fp_confirmPassword.setText("");
                fp_question.getSelectionModel().clearSelection();
                fp_answer.setText("");
                fp_username.setText("");

            }catch(SQLException e){e.printStackTrace();}

        }
    }

    public void backToLoginForm() {
        fp_questionForm.setVisible(false);
        fp_newPassForm.setVisible(false);
        si_loginForm.setVisible(true);
    }

    public void switchform(ActionEvent event)
    {
        TranslateTransition slider = new TranslateTransition();
        if(event.getSource() == site_createBtn)
        {
            slider.setNode(site_form);
            slider.setDuration(Duration.seconds(0.5));
            slider.setOnFinished((ActionEvent e) ->{
                site_aldreadyHave.setVisible(true);
                site_createBtn.setVisible(false);
                su_signupForm.setVisible(true);
                si_loginForm.setVisible(false);
                callQuestionList();

                fp_questionForm.setVisible(false);
                fp_newPassForm.setVisible(false);
            });

            slider.play();
        }else if(event.getSource() == site_aldreadyHave)
        {
            slider.setNode(site_form);
            slider.setDuration(Duration.seconds(0.5));
            slider.setOnFinished((ActionEvent e) ->{
                site_aldreadyHave.setVisible(false);
                site_createBtn.setVisible(true);
                su_signupForm.setVisible(false);
                si_loginForm.setVisible(true);
            });

            slider.play();
        }
    }

}