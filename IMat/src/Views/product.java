package Views;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class product extends AnchorPane {


    //fxid TILL Product
    @FXML
    private AnchorPane productAnchorPane;
    @FXML
    private ImageView productFavoriteStar, productImageItem, productPlusItem, productMinusItem;
    @FXML
    private Label productItemLabel, productPriceItem, amountItemProductView;
}
