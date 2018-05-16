package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class yourBuylist extends AnchorPane {

    //fxid TILL yourBuyList
    @FXML
    private AnchorPane minaInkopslistorAnchorPane;
    @FXML
    private Button minaInkopslistorFortsattHandlaButton;
    @FXML
    private Accordion minaInkopslistorAccordion;
    @FXML
    private Scrollbar minaInkopsListorScrollbar;

    private Controller parentController;
    private ShoppingItem product;

    public yourBuylist(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/yourBuylist.fxml"));
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
