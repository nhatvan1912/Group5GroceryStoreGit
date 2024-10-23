module com.example.group5grocerystore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
//    requires net.sf.jasperreports.core;
//    requires net.sf.jasperreports.engine;
    requires java.desktop; // Để hỗ trợ hiển thị báo cáo Jasper
    requires jasperreports;
    requires fontawesomefx;

    exports App;
    opens App to javafx.fxml;
}