package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class littleFoodLabelPane extends AnchorPane {

    //fxid TILL LittleFoodLabelPane
    @FXML private AnchorPane AnchorPanePopUpCart;
    @FXML private Label productNamePopUpCart;
    @FXML private Label amountProductsPopUpCart;
    @FXML private Label totalPricePopUpCart;
    @FXML private ImageView minusPopUpCart;
    @FXML private ImageView plusPopUpCart;
    @FXML private ImageView deleteProductPopUpCart;
    @FXML private ImageView productImagePopUpCart;

    private Controller parentController;
    private ShoppingItem product;

    public littleFoodLabelPane(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/littleFoodLabelPane.fxml"));
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
