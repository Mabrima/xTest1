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

public class littleFoodLabelPaneNoPlus extends AnchorPane {


    //fxid TILL LittleFoodLabelPaneNoPlus
    @FXML
    private AnchorPane littleFoodLabelNoPlusAnchorPane;
    @FXML
    private Label littleFoodLabelNoPlusVaraLabel, littleFoodLabelNoPlusAmountLabel, littleFoodLabelNoPlusPriceLabel;
    @FXML
    private ImageView littleFoodLabelNoPlusImage, littleFoodLabelNoPlusTrashImage;

    private Controller parentController;
    private ShoppingItem product;

    public littleFoodLabelPaneNoPlus(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/littleFoodLabelPaneNoPlus.fxml"));
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
