package Controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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


public class Controller implements Initializable {
    public IMatDataHandler dataHandler;
    List<CustomList> customLists;


    //För nu eftersom det är startsidan som con

    @FXML
    private AnchorPane homepageAnchorPane;
    @FXML
    private FlowPane flowPaneHomePage;


    @FXML
    private AnchorPane paymentStepOneAnchorPane;
    @FXML
    private AnchorPane areYouSureTakeAwaySavedTasksPane;

    //TODO many more button etc connections as well as a rigorous name check


    public void closeAreYouSureDeleteView(){
        areYouSureTakeAwaySavedTasksPane.toBack();
    }

    private String customListsFile() {
        return System.getProperty("user.home") + File.separatorChar + ".dat215" + File.separatorChar + "imat" + File.separatorChar + "customLists.txt";
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {


        dataHandler = IMatDataHandler.getInstance();
        loadCustomLists();
        updateCart();
        updateHomePage();


        //TODO add more connections for all the buttons etc and what they should do
        //might have to make toStartButton 1-x
    /*    homePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //TODO populate startScreen, needs integration with frontend
                //populatePaneFavorites;
            }
        });

       historyPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //myHistoryPane.toFront();
            }
        });


        myListPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                minaInkopslistorAnchorPane.toFront();
                //myListsPane.toFront();
            }
        });



        favoritePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //TODO bit more complicated, needs populateFavorites and populateAll, sort functions and so on
                //favoritesScreen.toFront();
            }
        });

        goToCheckout.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //checkoutPane.toFront();
            }
        });

        helpPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //helpPane.toFront();
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
        });*/


    }

    public void addCartAsCustomList(){
        CustomList list = new CustomList();
        list.setItems(dataHandler.getShoppingCart().getItems());
        customLists.add(list);
    }

    private void saveCustomLists() {
        System.out.println("saveCustomLists()");
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
    public void removeCustomerInfo(){
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

    public void clearCart(){
        dataHandler.getShoppingCart().clear();
    }

    public void populatePaneFavorites(){
        //TODO
    }

    public void populateHistoryPane(){
        //TODO
    }

    public void addOldOrderToCustomLists(Order order){
        //TODO should be able to get said order when you click the button
        CustomList newList = new CustomList();
        newList.setItems(order.getItems());
        customLists.add(newList);
    }

    //numId corresponds to where in the list of lists it is
    public void removeCustomList(int numId){
        customLists.remove(numId);
    }


    //to be called when program closes to save files
    public void shutDown(){
        saveCustomLists();
        dataHandler.shutDown();
        System.exit(0);
    }

    public void addToCart(){

    }

    //TODO add/remove favorite as well as a way to tell if said product is a favorite


    //försök att lägga varor i varukorgen
    @FXML private FlowPane cartListFlowPane;


    private void updateCart(){
         cartListFlowPane.getChildren().clear();
         List<ShoppingItem> products = dataHandler.getShoppingCart().getItems();


         for (int i = 0; i<products.size(); i++) //bör snyggas till
         {
             CartProductListing product = new CartProductListing(products.get(i), this);
             cartListFlowPane.getChildren().add(product);
         }
    }




    private void updateHomePage(){
        flowPaneHomePage.getChildren().clear();
        List<Product> allProducts= dataHandler.getProducts();


        for (int i = 0; i<allProducts.size(); i++) //bör snyggas till med
        {
            productGridItem productItem = new productGridItem(allProducts.get(i), this);
            flowPaneHomePage.getChildren().add(productItem);
        }


    }


}
