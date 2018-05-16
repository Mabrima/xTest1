package Views;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class foodLabelPane extends AnchorPane {

    //fxid TILL FoodLabelPane
    @FXML
    private AnchorPane foodLabelPaneAnchorPane;
    @FXML
    private Label foodLabelPaneVaraLabel, foodLabelPaneAmountLabel, foodLabelPanePrice;
    @FXML
    private ImageView foodLabelPlusImage, foodLabelPaneMinusImage, foodLabelPaneTrashImage;
}
