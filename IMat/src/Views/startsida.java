package Views;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;
import Controller.Controller;
import javafx.scene.control.Label;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class startsida extends AnchorPane{

    @FXML private ImageView ImatImageView;


    //fx:id till alla bakgrunder
    @FXML private AnchorPane HomePageAnchorPane;
    @FXML private AnchorPane MyListAnchorPane;
    @FXML private AnchorPane favoriteAnchorPane;
    @FXML private AnchorPane myHistoryAnchorPane;
    @FXML private AnchorPane helpAnchorPane;
    @FXML private StackPane categoryPane;

    @FXML private FlowPane categoryFlow;

    @FXML private FlowPane productFlow;             //denna används längst ner för att placera varorna på startsidan


    //fx:id för överskriften till de olika kategorisidorna (dvs antingen mejeri, kött osv)
    @FXML private Label categoryLabel;


    //fx:id för alla knappar
    @FXML private Button homePageButton;
    @FXML private Button myListPageButton;
    @FXML private Button favoritePageButton;
    @FXML private Button historyPageButton;
    @FXML private Button helpPageButton;


    @FXML private Button categoryButton;



    //ID för knapparna för kategoriknapparna
    // @FXML private TitledPane fruitVegetableButton;
    @FXML private Button fruitButton;
    @FXML private Button berryButton;
    @FXML private Button citrusFruitButton;
    @FXML private Button exoticFruitButton;
    @FXML private Button melonButton;
    @FXML private Button rootVegetableButton;
    @FXML private Button cabbageButton;




    @FXML private Button fishMeatChickenButton;
    @FXML private Button meatButton;
    @FXML private Button fishButton;
    @FXML private Button charkButton;

    @FXML private Button dairyButton;


    @FXML private Button beverageButton;


    //skafferi och dens subkategorier
    @FXML private Button skafferiButton;
    @FXML private Button pastaButton;
    @FXML private Button breadButton;
    @FXML private Button flourSugarSaltButton;
    @FXML private Button herbButton;
    @FXML private Button potatoRiceButton;
    @FXML private Button nutsSeedsButton;
    ;


    @FXML private Accordion homepageAccordion;

    @FXML private TitledPane homepageCathegorysTitledPane, fruitVegetableButton, meatFishButton, dairyProductsButton, pantryButton ;

    private Controller parentController;
    private ShoppingItem product;
    public IMatDataHandler dataHandler;

    public startsida(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/HomPage1.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        dataHandler = IMatDataHandler.getInstance();
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        homePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            //Lägger till alla produkter på startsidan
            addProducts(IMatDataHandler.getInstance().getProducts());
        });



        myListPageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            MyListAnchorPane.toFront();
        });



        favoritePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            favoriteAnchorPane.toFront();
        });


        historyPageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            myHistoryAnchorPane.toFront();
        });

        helpPageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            helpAnchorPane.toFront();
        });


        fruitButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            categoryLabel.setText("Frukt och Grönsaker");
            categoryPane.toFront();


            addProductsCategory(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));
            //addProducts(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));

        });

        //Skapar en lista med produkterna för protein.
        ArrayList<Product> fishMeatChickenList = new ArrayList<>();
        fishMeatChickenList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FISH));
        fishMeatChickenList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MEAT));


/*        fishMeatChickenButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            categoryLabel.setText("fishMeatChickenButton");
            categoryPane.toFront();

            addProducts(fishMeatChickenList);

        });
*/




/*        categoryButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            categoryLabel.setText("Alla produkter");
            categoryPane.toFront();

            addProducts(IMatDataHandler.getInstance().getProducts());
        });


  /*       fruitVegetableButton.setOnAction(e -> {
             HomePageAnchorPane.toFront();
             categoryLabel.setText("Frukt och Grönsaker");
             categoryPane.toFront();

             addProducts(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));

         });  */




        /*  categoryButton.setOnAction(e -> {
              HomePageAnchorPane.toFront();
              categoryLabel.setText("Kött och Fisk");
              categoryPane.toFront();

              addProducts(fishMeatChickenList);
          });*/


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








    //Metoden som lägger till produkter på startsidan
    private void addProducts(List<Product> pl){
        productFlow.getChildren().clear();
        try {
            for(Product p : pl) {

                productFlow.getChildren().add(new product(p));
                productFlow.getChildren().add(new javafx.scene.control.Label("   "));        //Detta ska tas bort och vi ska ändra produktens design istället!
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }




    private void addProductsCategory(List<Product> pl){
        categoryFlow.getChildren().clear();

        try {
            for(Product p : pl) {

                categoryFlow.getChildren().add(new product(p));
                categoryFlow.getChildren().add(new javafx.scene.control.Label("   "));        //Detta ska tas bort och vi ska ändra produktens design istället!
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}





/*

     //Skapar en lista med produkterna för frukt och grönsaker. kanske onödig lista då ett enum är vegetableFruit?
     ArrayList<Product> FruitVegetableList = new ArrayList<>();
             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.VEGETABLE_FRUIT));      //är detta som allt?
             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BERRY));
             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FRUIT));        //frukt är överordnad till citrusfrukter och exotiskafrukter?
            /* FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CITRUS_FRUIT));
             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.EXOTIC_FRUIT));*/
    /*         FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MELONS));
             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.ROOT_VEGETABLE));

             FruitVegetableList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.CABBAGE));


     //Skapar en lista med produkterna för skafferi.
     ArrayList<Product> SkafferiList = new ArrayList<>();
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.BREAD));
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FLOUR_SUGAR_SALT));
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HERB));
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.PASTA));
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.POTATO_RICE));
             SkafferiList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.NUTS_AND_SEEDS));



     //Skapar en lista med produkterna för skafferi.
     ArrayList<Product> BeverageList = new ArrayList<>();
             BeverageList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.COLD_DRINKS));
             BeverageList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.HOT_DRINKS));

     //Skapar en lista med produkter för mejeri.
     ArrayList<Product> DairyList = new ArrayList<>();
             DairyList.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.DAIRIES));





             /*Hur man lägger till den listan man vill på skärmen på startsidan är detta nu.
             addProducts(DairyList);*/



