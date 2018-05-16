package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Views.startsida;

import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ResourceBundle rb = java.util.ResourceBundle.getBundle("Controller/ResourceBundle");

        //Parent root = FXMLLoader.load(getClass().getResource("FXML.filer/startsidan.fxml"), rb);


        startsida startsida = new startsida();

        Scene scene = new Scene(startsida, 1368, 768);

        stage.setTitle(rb.getString("application.name"));
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
