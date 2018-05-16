import Controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;


public class CartProductListing extends AnchorPane{

    private Controller parentController;
    private Product product;

    //@FXML

    //TODO maybe just use littleFoodLabel here as well, is there any difference?
    public CartProductListing(Product product, Controller controller){             //BV vi hade döpt den cartList så behövs ändras i varukorg.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LittleFoodLabelPane"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = product;                 //BV hade skrivit this.shoppingitem= shoppingitem;
        this.parentController = controller;     //BV hade skrivit this.parentController=parentController;

        /* Bv vi hade sedan skrivit:

                productImagePopUpCart.setImage(imatdatahandler.getFXImage(shoppingitem.getProduct()));

                productNamePopUpCart.setText(this.shoppingitem.getProduct().getName());

                totalPricePopUpCart.setText(this.shoppingitem.getProduct().getPrice() + "kr");
         */

    }

}
