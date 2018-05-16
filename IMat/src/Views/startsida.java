package Views;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;
import Controller.Controller;


import java.awt.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;




public class startsida extends AnchorPane{
    //fxid TILL startsidan

    @FXML
    private AnchorPane homepageAnchorPane;
    @FXML
    private ImageView ImatImageView;
    @FXML
    private Button homePageButton, myListPageButton, favoritePageButton, historyPageButton, helpPageButton, fruitButton, vegetableButton, meatButton, fishButton;
    @FXML
    private  Button  charkButton, dairyCookingButton, lactoseFreeButton, bakingButton, cannedFoodButton, pastaRiceButton;
    @FXML
    private FlowPane flowPaneHomePage;
    @FXML
    private Accordion homepageAccordion;
    @FXML
    private TitledPane homepageCathegorysTitledPane, fruitVegetableButton, meatFishButton, dairyProductsButton, pantryButton ;

    private Controller parentController;
    private ShoppingItem product;

    public startsida(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/startsida.fxml"));
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
