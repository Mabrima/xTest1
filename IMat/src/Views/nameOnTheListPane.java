package Views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class nameOnTheListPane extends AnchorPane {


    //fxid TILL nameOnTheListPane
    @FXML
    private AnchorPane namnPaListanAnchorPane, namnPaListanVarorPane;
    @FXML
    private TextField namnPaListanTextfalt;
    @FXML
    private Label namnPaListanLabel;
    @FXML
    private javafx.scene.control.Button namnPaListaFortsattHandlaButton, namnPaListaSparaButton;
    @FXML
    private ImageView namnPaListanKryss;
    @FXML
    private Scrollbar namnPaListaScrollbar;
}
