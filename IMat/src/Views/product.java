package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingCart;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class product extends AnchorPane {


    //fxid TILL Product
    @FXML
    private AnchorPane productAnchorPane;
    @FXML
    private ImageView productFavoriteStar;
    @FXML
    private  ImageView productImageItem;
    @FXML
    private ImageView productPlusItem;
    @FXML
    private  ImageView productMinusItem;
    @FXML
    private Label productItemLabel;
    @FXML
    private Label productPriceItem;
    @FXML
    private Label amountItemProductView;
    @FXML
    private Button transparentButtonStar;
    @FXML
    private Button transparentButtonMinus;
    @FXML
    private Button transparentButtonPlus;


    private Controller parentController;
    private ShoppingItem product2;
    Product product;
    IMatDataHandler db= IMatDataHandler.getInstance();
    ShoppingCart shoppingCart;

    public product(Product product) throws IOException{
        this.product = product;
        System.out.println(product.getName());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/product.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        fxmlLoader.load();


        productImageItem.setImage(db.getFXImage(product, 100, 100));
        productItemLabel.setText(product.getName());
        productPriceItem.setText(Double.toString(product.getPrice()) + product.getUnit());

        //TODO alice lägger till grejer nedan om + och - knappar samt "antal label"
       // amountItemProductView.setText(Double.toString(product.get));



        shoppingCart = db.getShoppingCart();

        transparentButtonPlus.setOnAction(e -> {
            amountItemProductVi

        });





    }

}
