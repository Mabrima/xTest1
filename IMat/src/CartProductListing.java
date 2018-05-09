import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;


public class CartProductListing extends AnchorPane{

    private Controller parentController;
    private Product product;

    //@FXML

    public CartProductListing(Product product, Controller controller){
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

}
