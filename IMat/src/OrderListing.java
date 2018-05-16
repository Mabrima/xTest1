import Controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;


public class OrderListing extends AnchorPane {

    private Controller parentController;
    private Product product;

    //@FXML
    //TODO is supposed to be for showing the custom lists. Need to talk about the integration with the drop down boxes.

    public OrderListing(Product product, Controller controller){
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
