package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class myShoppingCart extends AnchorPane {

    //fxid TILL myShoppingCart
    @FXML
    private AnchorPane minVarukorgAnchorPane;
    @FXML
    private Label minVarukorgLabel, minVarukorgTotaltLabel;
    @FXML
    private javafx.scene.control.Button minVarukorgFortsattHandlaButton, minVarukorgTaBortButton, minVarukorgSparaListaButton, minVarukorgTillBetalningButton;
    @FXML
    private Scrollbar minVarukorgScrollbar;


    private Controller parentController;
    private ShoppingItem product;

    public myShoppingCart(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/myShoppingCart.fxml"));
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
