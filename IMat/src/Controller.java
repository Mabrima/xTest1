import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import se.chalmers.cse.dat216.project.*;



public class Controller {
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

    //För att demonstrera hur dataHandlern kommer fungera
    public void test(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.findProducts("type");
        Customer customer = dataHandler.getCustomer();
        CreditCard creditCard = dataHandler.getCreditCard();



    }

    public void initialize(){


        toCheckoutButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //checkoutScreen.toFront();
            }
        });
    }

}
