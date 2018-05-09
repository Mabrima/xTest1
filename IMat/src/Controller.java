import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.cse.dat216.project.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Controller {
    IMatDataHandler dataHandler;
    List<CustomList> customLists;
    Date date;
    private static final DateFormat customListDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @FXML
    private Button homePageButton;
<<<<<<< HEAD

=======
>>>>>>> f997d0924fa998e00a10e5efdb8833986c89ed99
    @FXML
    private Button toCheckoutButton;
    @FXML
    private Button helpPageButton;
    @FXML
    private Button historyPageButton;
    @FXML
    private Button myListPageButton;
    @FXML
    private Button favoritePageButton;
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
        loadCustomlists();

        //might have to make toStartButton 1-x
        homePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //startScreen.toFront();
            }
        });

        historyPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //historyScreen.toFront();
            }
        });

        myListPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //customListsScreen.toFront();
            }
        });

        favoritePageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
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

        helpPageButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
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
                    List<Product> productList = dataHandler.findProducts(searchText);
                    //handle productList
                }
            }
        });
    }

    public void addCartAsCustomList(){
        CustomList list = new CustomList();
        list.setDate(date);
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
                line = "" + customListDateFormat.format(customList.getDate()) + "\n";
                osw.write(line);
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

    private void loadCustomlists() {
        File orderDir = new File(this.customListsFile());
        if(orderDir.isDirectory()) {
            File[] files = orderDir.listFiles();

            for(int i = 0; i < files.length; ++i) {
                File thisFile = files[i];
                if(!thisFile.isHidden() && thisFile.getName().endsWith(".txt")) {
                    this.loadCustomlist(thisFile);
                }
            }
        }

    }

    private void loadCustomlist(File f) {
        try {
            BufferedReader exc = new BufferedReader(new InputStreamReader(new FileInputStream(f), "ISO-8859-1"));
            CustomList customList = new CustomList();
            ArrayList items = new ArrayList();
            String line;
            if((line = exc.readLine()) != null) {
                this.customLists.add(customList);
            }

            if((line = exc.readLine()) != null) {
                Date tokens;
                try {
                    tokens = customListDateFormat.parse(line);
                } catch (Exception var11) {
                    tokens = new Date();
                }

                customList.setDate(tokens);
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


}
