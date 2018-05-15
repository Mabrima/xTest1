import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ResourceBundle rb = java.util.ResourceBundle.getBundle("ResourceBundle");

        Parent root = FXMLLoader.load(getClass().getResource("FXML.filer/paymentStepOne.fxml"), rb);

        Scene scene = new Scene(root, 1400, 800);

        stage.setTitle(rb.getString("application.name"));
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
