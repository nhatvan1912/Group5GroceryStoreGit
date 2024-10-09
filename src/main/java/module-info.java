module com.example.group5grocerystore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    exports App;
    opens App to javafx.fxml;
}