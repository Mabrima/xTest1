import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class cartList extends AnchorPane {


    @FXML private ImageView productImagePopUpCart;
    @FXML private Label productNamePopUpCart;
    @FXML private Label amountProductsPopUpCart;
    @FXML private Label totalPricePopUpCart;
    @FXML private ImageView minusPopUpCart;
    @FXML private ImageView plusPopUpCart;
    @FXML private ImageView deleteProductPopUpCart;

    IMatDataHandler imatdatahandler;


    private Controller parentController;
    private ShoppingItem shoppingitem;

    public cartList(ShoppingItem shoppingitem, Controller parentController){
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("LittleFoodLabelPane"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        this.shoppingitem= shoppingitem;
        this.parentController=parentController;

        productImagePopUpCart.setImage(imatdatahandler.getFXImage(shoppingitem.getProduct()));

        productNamePopUpCart.setText(this.shoppingitem.getProduct().getName());

       // amountProductsPopUpCart.setText();

        totalPricePopUpCart.setText(this.shoppingitem.getProduct().getPrice() + "kr");

    }
}
