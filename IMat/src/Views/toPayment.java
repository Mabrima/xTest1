package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class toPayment extends AnchorPane {
    //fxid TILL toPayment
    @FXML
    private AnchorPane minaVarorAnchorPane, minaVarorVaraAnchorPane;
    @FXML
    private Scrollbar minaVarorScrollPane;
    @FXML
    private Button minaVarorSparaListaButton, minaVarorFortsattHandlaButton, minaVarorTillBetalningButton;

    private Controller parentController;
    private ShoppingItem product;

    public toPayment(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/toPayment.fxml"));
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
