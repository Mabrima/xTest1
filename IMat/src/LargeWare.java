import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

/**
 * Created by mabrima27 on 11-May-18.
 */
public class LargeWare {
    private Product product;
    private Controller parentController;
    @FXML
    private AnchorPane largeWaresPane;

    public LargeWare(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("name.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = product;
        this.parentController = controller;

    }

    private void increaseWare(){

    }


}
