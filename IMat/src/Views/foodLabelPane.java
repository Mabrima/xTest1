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

public class foodLabelPane extends AnchorPane {

    //fxid TILL FoodLabelPane
    @FXML private AnchorPane foodLabelPaneAnchorPane;
    @FXML private Label foodLabelPaneVaraLabel;
    @FXML private Label foodLabelPaneAmountLabel;
    @FXML private Label foodLabelPanePrice;
    @FXML private ImageView foodLabelPlusImage;
    @FXML private ImageView foodLabelPaneMinusImage;
    @FXML private ImageView foodLabelPaneTrashImage;
    @FXML private Controller parentController;
    @FXML private ShoppingItem product;

    public foodLabelPane(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/foodLabelPane.fxml"));
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
