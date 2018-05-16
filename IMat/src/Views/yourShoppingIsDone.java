package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class yourShoppingIsDone extends AnchorPane{

    //fxid TILL YourShoppingIsDone
    @FXML
    private AnchorPane genomfortAnchorPane;
    @FXML
    private Button genomfortOkejButton;
    @FXML
    private ImageView genomfortKryssImage;

    private Controller parentController;
    private ShoppingItem product;

    public yourShoppingIsDone(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/yourShoppingIsDone.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = new ShoppingItem(product);
        this.parentController = controller;

    }
}
