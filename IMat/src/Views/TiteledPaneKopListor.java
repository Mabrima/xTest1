package Views;

import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class TiteledPaneKopListor extends AnchorPane {
    //fxid TILL TitledPaneKöpListor
    @FXML
    private AnchorPane KopListorTillAccordionAnchorPane;
    @FXML
    private TitledPane minaInkopslistorTitledPane;
    @FXML
    private Label titledPaneKopListorPriceLabel;
    @FXML
    private javafx.scene.control.Button titledPaneKopListorListaIVarukorgButton, titledPaneKopListorRedigeraButton, titledPaneKopListorRemoveButton;
}
