import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.cse.dat216.project.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Controller {
    IMatDataHandler dataHandler;
    List<CustomList> customLists;
    Date date;

    @FXML
    private Button toStartButton;
    @FXML
    private Button toCheckoutButton;
    @FXML
    private Button toHelpButton;
    @FXML
    private Button toHistoryButton;
    @FXML
    private Button toCustomListsButton;
    @FXML
    private Button toFavoritesButton;
    @FXML
    private TextField searchField;

    private String customListsFile() {
        return System.getProperty("user.home") + File.separatorChar + ".dat215" + File.separatorChar + "imat" + File.separatorChar + "customLists.txt";
    }

    //För att demonstrera hur dataHandlern kommer fungera
    public void test(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.findProducts("type");
        Customer customer = dataHandler.getCustomer();
        CreditCard creditCard = dataHandler.getCreditCard();



    }

    public void initialize(){

        dataHandler = IMatDataHandler.getInstance();

        //might have to make toStartButton 1-x
        toStartButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //startScreen.toFront();
            }
        });

        toHistoryButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //historyScreen.toFront();
            }
        });

        toCustomListsButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //customListsScreen.toFront();
            }
        });

        toFavoritesButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //favoritesScreen.toFront();
            }
        });

        toCheckoutButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //checkoutScreen.toFront();
            }
        });

        toHelpButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //helpScreen.toFront();
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
                    List<Product> productList = dataHandler.findProducts(searchText); //Would have loved to add some leniency here
                    //handle productList
                }
            }
        });
    }

    public void addCartAsCustomList(){
        customLists.add(new CustomList(date, dataHandler.getShoppingCart().getItems()));
    }




    private void saveProducts() {
        try {
            FileOutputStream fos = new FileOutputStream(this.customListsFile());
            OutputStreamWriter osw = new OutputStreamWriter(fos, "ISO-8859-1");
            System.out.println("saveCustomLists()");
            Iterator var3 = this.customLists.iterator();

            while(var3.hasNext()) {
                Product p = (Product)var3.next();
                String line = "";
                line = p.getProductId() + ";" + p.getCategory() + ";" + p.getName() + ";" + p.getPrice() + ";" + p.getUnit() + ";" + p.getImageName() + ";" + "end\n";
                osw.write(line);
            }

            osw.flush();
            osw.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
}
