package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class searchBar extends AnchorPane {


    //fxid TILL SearchBar
    @FXML
    private AnchorPane searchbarAnchorPane;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton, searchbarContinueShoppingButton, searchbarGoToCheckout, searchbarCart;

    private Controller parentController;
    private ShoppingItem product;

    public searchBar(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/searchBar.fxml"));
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
