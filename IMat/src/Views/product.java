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

public class product extends AnchorPane {


    //fxid TILL Product
    @FXML
    private AnchorPane productAnchorPane;
    @FXML
    private ImageView productFavoriteStar, productImageItem, productPlusItem, productMinusItem;
    @FXML
    private Label productItemLabel, productPriceItem, amountItemProductView;

    private Controller parentController;
    private ShoppingItem product;

    public product(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/product.fxml"));
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
