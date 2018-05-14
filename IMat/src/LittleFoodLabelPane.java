import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class LittleFoodLabelPane {
    private ShoppingItem product;
    private Controller parentController;
    @FXML
    private Label littleFoodLabelProductLabel, littleFoodLabelKronor, littleFoodLabelAmount;
    @FXML
    private ImageView littleFoodLabelPlusImage, littleFoodLabelMinusImage, littleFoodLabelTrashImage;

    public LittleFoodLabelPane(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/LittleFoodLabelPane.fxml"));
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

    private void addMoreToCart(){
        parentController.dataHandler.getShoppingCart().addItem(product);
    }

    private void removeFromCart(){
        parentController.dataHandler.getShoppingCart().removeItem(product);
    }

}
