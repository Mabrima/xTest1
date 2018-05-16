package Views;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.awt.*;

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
}
