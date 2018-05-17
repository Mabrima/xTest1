package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class nameOnTheListPane extends AnchorPane {


    //fxid TILL nameOnTheListPane
    @FXML private AnchorPane namnPaListanAnchorPane;
    @FXML private AnchorPane namnPaListanVarorPane;
    @FXML private TextField namnPaListanTextfalt;
    @FXML private Label namnPaListanLabel;
    @FXML private javafx.scene.control.Button namnPaListaFortsattHandlaButton;
    @FXML private javafx.scene.control.Button namnPaListaSparaButton;
    @FXML private ImageView namnPaListanKryss;
    @FXML private Scrollbar namnPaListaScrollbar;

    private Controller parentController;
    private ShoppingItem product;

    public nameOnTheListPane(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/nameOnTheListPane.fxml"));
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
