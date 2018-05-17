package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class paymentStepOne extends AnchorPane {

    //fxid TILL PaymentStepOne
    @FXML private AnchorPane paymentStepOneAnchorPane;
    @FXML private DatePicker chooseDateDatePickerPaymentStepOne;
    @FXML private Button continueShoppingButtonPaymentStepOne;
    @FXML private Button changeMyInfoButton;
    @FXML private Button deleteMyInfoButton;
    @FXML private Button nextToPaymentButton;
    @FXML private TextField nameInfoTextField;
    @FXML private TextField addressTextField;
    @FXML private TextField postNumberTextField;
    @FXML private TextField phoneNumberTextField;
    @FXML private TextField emailTextField;
    @FXML private RadioButton time7to11RadioButton;
    @FXML private RadioButton time11to15RadioButton;
    @FXML private RadioButton time15to19RadioButton;

    private Controller parentController;
    private ShoppingItem product;

    public paymentStepOne(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/paymentStepOne.fxml"));
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
