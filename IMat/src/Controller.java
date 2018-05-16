import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import se.chalmers.cse.dat216.project.*;

import java.awt.*;
import java.awt.Label;
import java.awt.ScrollPane;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class Controller implements Initializable{
    IMatDataHandler dataHandler;
    List<CustomList> customLists;
    Date date;
    private static final DateFormat customListDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //NEDAN STÅR ALLA FXML FXIDn i samma ordning som de står i FXML.filer listan till vänster.

    //fxid TILL AreYouSureDeleteSavedInfo
   @FXML
    private AnchorPane areYouSureTakeAwaySavedTasksPane;
    @FXML
    private ImageView areYouSureCrossImage;
   @FXML
    private Label areYouSureLabel;
   @FXML
    private Button areYouSureYesButton, areYouSureNoButton, areYouSureCancelButton;


    //fxid TILL FoodLabelPane
    @FXML
    private AnchorPane foodLabelPaneAnchorPane;
    @FXML
    private Label foodLabelPaneVaraLabel, foodLabelPaneAmountLabel, foodLabelPanePrice;
    @FXML
    private ImageView foodLabelPlusImage, foodLabelPaneMinusImage, foodLabelPaneTrashImage;


    //fxid TILL FoodLabelPaneNoPlus
    @FXML
    private AnchorPane foodPaneNoPlusAnchorPane;
    @FXML
    private Label foodPaneNoPlusVaraLabel, foodPaneNoPlusPriceLabel;
    @FXML
    private ImageView foodPaneNoPlusTrashImage, foodPaneNoPlusImageView;


    //fxid TILL LittleFoodLabelPane
    @FXML
    private AnchorPane AnchorPanePopUpCart;
    @FXML
    private Label productNamePopUpCart, amountProductsPopUpCart, totalPricePopUpCart;
    @FXML
    private ImageView minusPopUpCart, plusPopUpCart, deleteProductPopUpCart, productImagePopUpCart;


    //fxid TILL LittleFoodLabelPaneNoPlus
    @FXML
    private AnchorPane littleFoodLabelNoPlusAnchorPane;
    @FXML
    private Label littleFoodLabelNoPlusVaraLabel, littleFoodLabelNoPlusAmountLabel, littleFoodLabelNoPlusPriceLabel;
    @FXML
    private ImageView littleFoodLabelNoPlusImage, littleFoodLabelNoPlusTrashImage;


    //fxid TILL myShoppingCart
    @FXML
    private AnchorPane minVarukorgAnchorPane;
    @FXML
    private Label minVarukorgLabel, minVarukorgTotaltLabel;
    @FXML
    private Button minVarukorgFortsattHandlaButton, minVarukorgTaBortButton, minVarukorgSparaListaButton, minVarukorgTillBetalningButton;
    @FXML
    private Scrollbar minVarukorgScrollbar;


    //fxid TILL nameOnTheListPane
    @FXML
    private AnchorPane namnPaListanAnchorPane, namnPaListanVarorPane;
    @FXML
    private TextField namnPaListanTextfalt;
    @FXML
    private Label namnPaListanLabel;
    @FXML
    private Button namnPaListaFortsattHandlaButton, namnPaListaSparaButton;
    @FXML
    private ImageView namnPaListanKryss;
    @FXML
    private Scrollbar namnPaListaScrollbar;


    //fxid TILL PaymentStepOne
    @FXML
    private AnchorPane paymentStepOneAnchorPane;
    @FXML
    private DatePicker chooseDateDatePickerPaymentStepOne;
    @FXML
    private Button continueShoppingButtonPaymentStepOne, changeMyInfoButton, deleteMyInfoButton, nextToPaymentButton;
    @FXML
    private TextField nameInfoTextField, addressTextField, postNumberTextField, phoneNumberTextField, emailTextField;
    @FXML
    private RadioButton time7to11RadioButton, time11to15RadioButton, time15to19RadioButton;


    //fxid TILL PaymentStepTwo
    @FXML
    private AnchorPane paymentStepTwoAnchorPane;
    @FXML
    private Button backToPaymentStepOne, completePaymentButton, deleteMyCardInfoButton, changeMyCardInfoButton, continueShoppingButtonPaymentStepTwo;
    @FXML
    private TextField bankNameTextField, cardNameTextField, cardNumberTextField, expireDateTextfield, expireMonthTextField, ccvTextField;


    //fxid TILL Product
    @FXML
    private AnchorPane productAnchorPane;
    @FXML
    private ImageView productFavoriteStar, productImageItem, productPlusItem, productMinusItem;
    @FXML
    private Label productItemLabel, productPriceItem, amountItemProductView;


    //fxid TILL SearchBar
    @FXML
    private AnchorPane searchbarAnchorPane;
    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton, searchbarContinueShoppingButton, searchbarGoToCheckout, searchbarCart;


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


    //fxid TILL TitledPaneKöpListor
    @FXML
    private AnchorPane minaInkopslistorAnchorPane;
    @FXML
    private TitledPane minaInkopslistorTitledPane;
    @FXML
    private Label titledPaneKopListorPriceLabel;
    @FXML
    private Button titledPaneKopListorListaIVarukorgButton, titledPaneKopListorRedigeraButton, titledPaneKopListorRemoveButton;


    //fxid TILL toPayment
    @FXML
    private AnchorPane minaVarorAnchorPane, minaVarorVaraAnchorPane,
    @FXML
    private Scrollbar minaVarorScrollPane;
    @FXML
    private Button minaVarorSparaListaButton, minaVarorFortsattHandlaButton, minaVarorTillBetalningButton;


    //fxid TILL Varukorg
    @FXML
    private AnchorPane varukorgAnchorPane;
    @FXML
    private FlowPane varukorgFlowPane;
    @FXML
    private Label shoppingCartTotalLabel;
    @FXML
    private Button varukorgKeepShoppingButton, varukorgTaBortButton, varukorgGoPaymentButton;
    @FXML
    private ImageView varukorgCrossImage;

    //fxid TILL yourBuyList
    @FXML
    private AnchorPane minaInkopslistorAnchorPane;
    @FXML
    private Button minaInkopslistorFortsattHandlaButton;
    @FXML
    private Accordion minaInkopslistorAccordion;
    @FXML
    private Scrollbar minaInkopsListorScrollbar;
    @FXML
    private AnchorPane


    //fxid TILL YourShoppingIsDone
    @FXML
    private AnchorPane genomfortAnchorPane;
    @FXML
    private Button genomfortOkejButton;
    @FXML
    private ImageView genomfortKryssImage;




    //TODO many more button etc connections as well as a rigorous name check

    @FXML //all crossImageViews
    private ImageView areYouSureCrossImage, homePageImage;
    @FXML
    private AnchorPane areYouSureTakeAwaySavedInfoPane, shoppingPane, cheackoutPane, getPaymentStepOnePane, paymentStepTwoPane; //panes
    @FXML
    private AnchorPane myHistoryPane, myListsPane, helpPane, finishedPane, shoppingCartPane; //more panes
    @FXML
    private Button checkoutButton, helpPageButton, historyPageButton; //main page buttons
    @FXML
    private Button areYouSureYesButton, areYouSureNoButton, areYouSureCancelButton; //areYouSureDeleteSavedInfoPane buttons
    @FXML
    private Button completePaymentButton, backToPaymentStepOne, continueShoppingButtonPaymentStepTwo, changeMyCardInfoButton, deleteMyCardInfoButton; //paymentPaneTwo buttons
    @FXML
    private Button largeWaresPlusButton; //TODO
    @FXML
    private Button myWaresToPaymentButton, myWaresSaveListButton, myWaresKeepShoppingButton; //TODO what are these? shoppingCart? maybe irrelevant now

    @FXML
    private Button shoppingCartEmptyCartButton, shoppingCartSaveListButton, shoppingCartToPaymentButton, shoppingCartKeepShoppingButton; //shoppingCartButtons
    @FXML
    private Label shoppingCartTotalLabel;

    //TODO add focus property to all TextFields (except searchfield) so that they save once you are done writing
    @FXML
    private TextField searchField;
    @FXML
    private TextField cardNumberTextField, expireDateTextfield, expireMonthTextField, ccvTextField; //paymentPaneTwo textFields


    private String customListsFile() {
        return System.getProperty("user.home") + File.separatorChar + ".dat215" + File.separatorChar + "imat" + File.separatorChar + "customLists.txt";
    }


    @Override
    public void initialize(URL url, ResourceBundle rb){

        dataHandler = IMatDataHandler.getInstance();
        loadCustomLists();



        //TODO add more connections for all the buttons etc and what they should do
        //might have to make toStartButton 1-x
        homePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //TODO populate startScreen, needs integration with frontend
                //populatePaneFavorites;
            }
        });

        myWaresKeepShoppingButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //populatePaneFavorites;
            }
        });

        historyPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                myHistoryPane.toFront();
            }
        });

        myListPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                minaInkopslistorAnchorPane.toFront();
            }
        });

        favoritePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //TODO bit more complicated, needs populateFavorites and populateAll, sort functions and so on
                //favoritesScreen.toFront();
            }
        });

        checkoutButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                cheackoutPane.toFront();
            }
        });

        helpPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                helpPane.toFront();
            }
        });

        searchField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                if(newValue){
                    //focusgained - do nothing
                }
                else{
                    String searchText = searchField.getAccessibleText();
                    List<Product> productList = dataHandler.findProducts(searchText);
                    //TODO handle productList
                }
            }
        });
    }

    public void addCartAsCustomList(){
        CustomList list = new CustomList();
        list.setItems(dataHandler.getShoppingCart().getItems());
        customLists.add(list);
    }

    private void saveCustomLists() {
        System.out.println("saveOrders()");
        Iterator var1 = this.customLists.iterator();

        while(var1.hasNext()) {
            CustomList customList = (CustomList) var1.next();
            String filename = this.customListsFile();

            try {
                FileOutputStream exc = new FileOutputStream(filename);
                OutputStreamWriter osw = new OutputStreamWriter(exc, "ISO-8859-1");
                String line = "";
                List items = customList.getItems();
                Iterator var8 = items.iterator();

                while(var8.hasNext()) {
                    ShoppingItem item = (ShoppingItem)var8.next();
                    line = "" + item.getProduct().getProductId() + ";" + item.getAmount() + "\n";
                    osw.write(line);
                }

                osw.flush();
                osw.close();
            } catch (IOException var10) {
                var10.printStackTrace();
            }
        }

    }

    private void loadCustomLists() {
        File orderDir = new File(this.customListsFile());
        if(orderDir.isDirectory()) {
            File[] files = orderDir.listFiles();

            for(int i = 0; i < files.length; ++i) {
                File thisFile = files[i];
                if(!thisFile.isHidden() && thisFile.getName().endsWith(".txt")) {
                    this.loadCustomList(thisFile);
                }
            }
        }

    }

    private void loadCustomList(File f) {
        try {
            BufferedReader exc = new BufferedReader(new InputStreamReader(new FileInputStream(f), "ISO-8859-1"));
            CustomList customList = new CustomList();
            ArrayList items = new ArrayList();
            String line;
            if((line = exc.readLine()) != null) {
                this.customLists.add(customList);
            }

            while((line = exc.readLine()) != null) {
                String[] tokens1 = line.split(";");
                if(tokens1.length == 2) {
                    Product p = dataHandler.getProduct(Integer.parseInt(tokens1[0]));
                    double amount = Double.parseDouble(tokens1[1]);
                    ShoppingItem sci = new ShoppingItem(p, amount);
                    items.add(sci);
                }
            }

            customList.setItems(items);
            exc.close();
        } catch (IOException var12) {
            var12.printStackTrace();
        }

    }

    @FXML
    private void removeCustomerInfo(){
        Customer customer = dataHandler.getCustomer();
        CreditCard creditCard = dataHandler.getCreditCard();
        creditCard.setCardNumber("");
        creditCard.setCardType("");
        creditCard.setHoldersName("");
        creditCard.setValidMonth(4);
        creditCard.setValidYear(18);
        creditCard.setVerificationCode(0);
        customer.setAddress("");
        customer.setEmail("");
        customer.setFirstName("");
        customer.setLastName("");
        customer.setMobilePhoneNumber("");
        customer.setPhoneNumber("");
        customer.setPostAddress("");
        customer.setPostCode("");
        //todo Uppdate the screen
    }

    private void clearCart(){
        dataHandler.getShoppingCart().clear();
    }

    private void populatePaneFavorites(){
        //TODO
    }

    private void populateHistoryPane(){
        //TODO
    }

    private void addOldOrderToCustomLists(Order order){
        //TODO should be able to get said order when you click the button
        CustomList newList = new CustomList();
        newList.setItems(order.getItems());
        customLists.add(newList);
    }

    private void removeCustomList(int numId){
        customLists.remove(numId);
    }

    private void shutDown(){
        saveCustomLists();
        dataHandler.shutDown();
        System.exit(0);
    }

    private void addToCart(){

    }

    @FXML private FlowPane cartListFlowPane;
    ShoppingCart shoppingcart;
    private void updateCart(){
        cartListFlowPane.getChildren().clear();
         List<ShoppingItem> products= shoppingcart.getItems();


         for (int i = 0; i<products.size(); i++) //bör snyggas till
         {
             cartList product = new cartList(products.get(i), this);
             cartListFlowPane.getChildren().add(product);
         }



    }


}
