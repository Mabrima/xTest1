package Views;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class littleFoodLabelPane extends AnchorPane {

    //fxid TILL LittleFoodLabelPane
    @FXML
    private AnchorPane AnchorPanePopUpCart;
    @FXML
    private Label productNamePopUpCart, amountProductsPopUpCart, totalPricePopUpCart;
    @FXML
    private ImageView minusPopUpCart, plusPopUpCart, deleteProductPopUpCart, productImagePopUpCart;
}
