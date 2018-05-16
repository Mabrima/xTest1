package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class varukorg extends AnchorPane{
    //fxid TILL Varukorg
    @FXML
    private AnchorPane varukorgAnchorPane;
    @FXML
    private FlowPane varukorgFlowPane;
    @FXML
    private Label shoppingCartTotalLabel;
    @FXML
    private javafx.scene.control.Button varukorgKeepShoppingButton, varukorgTaBortButton, varukorgGoPaymentButton;
    @FXML
    private ImageView varukorgCrossImage;

    private Controller parentController;
    private ShoppingItem product;

    public varukorg(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/varukorg.fxml"));
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
