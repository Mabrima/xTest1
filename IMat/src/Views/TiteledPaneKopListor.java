package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class TiteledPaneKopListor extends TitledPane {
    //fxid TILL TitledPaneKöpListor
    @FXML private AnchorPane KopListorTillAccordionAnchorPane;
    @FXML private TitledPane minaInkopslistorTitledPane;
    @FXML private Label titledPaneKopListorPriceLabel;
    @FXML private javafx.scene.control.Button titledPaneKopListorListaIVarukorgButton;
    @FXML private Button titledPaneKopListorRedigeraButton;
    @FXML private Button titledPaneKopListorRemoveButton;

    private Controller parentController;
    private ShoppingItem product;

    public TiteledPaneKopListor(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/TitledPaneKöpListor.fxml"));
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
