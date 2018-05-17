package Views;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;
import Controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
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

    @FXML AnchorPane HomePageAnchorPane;
    @FXML private ImageView ImatImageView;
    @FXML private Button homePageButton;
    @FXML private Button myListPageButton;
    @FXML private Button favoritePageButton;
    @FXML private Button historyPageButton;
    @FXML private Button helpPageButton;
    @FXML private Button fruitButton;
    @FXML private Button vegetableButton;
    @FXML private Button meatButton;
    @FXML private Button fishButton;
    @FXML private Button  charkButton;
    @FXML private Button dairyCookingButton;
    @FXML private Button lactoseFreeButton;
    @FXML private Button bakingButton;
    @FXML private Button cannedFoodButton;
    @FXML private Button pastaRiceButton;
    @FXML private FlowPane flowPaneHomePage;
    @FXML private Accordion homepageAccordion;
    @FXML private TitledPane homepageCathegorysTitledPane, fruitVegetableButton, meatFishButton, dairyProductsButton, pantryButton ;

    private Controller parentController;
    private ShoppingItem product;


    public startsida(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/HomPage1.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        myListPageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            MyListAnchorPane.toFront();
        });
        homePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
        });
        favoritePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            favoriteAnchorPane.toFront();
        });
    }

    public startsida(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/HomPage1.fxml"));
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

   // @FXML AnchorPane HomePageAnchorPane;
    @FXML AnchorPane MyListAnchorPane;
    @FXML AnchorPane favoriteAnchorPane;






}
