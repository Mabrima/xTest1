import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingCart;

import java.io.IOException;

//TODO mighr be outdated and ready for deletion

public class LargeWare {
    private Product product;
    private Controller parentController;
    private ShoppingCart shoppingCart;
    private int itemInList;
    @FXML
    private AnchorPane largeWaresPane;

    public LargeWare(Product product, Controller controller, ShoppingCart shoppingCart){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("name.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        //This is a huge mess, come back later

        this.product = product;
        this.parentController = controller;
        this.shoppingCart = shoppingCart;

    }

    private void increaseWare(){
        shoppingCart.addItem(shoppingCart.getItems().get(itemInList));
    }


}
