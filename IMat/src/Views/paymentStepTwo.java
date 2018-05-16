package Views;

import Controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.io.IOException;

public class paymentStepTwo extends AnchorPane {

    //fxid TILL PaymentStepTwo
    @FXML
    private AnchorPane paymentStepTwoAnchorPane;
    @FXML
    private Button backToPaymentStepOne, completePaymentButton, deleteMyCardInfoButton, changeMyCardInfoButton, continueShoppingButtonPaymentStepTwo;
    @FXML
    private TextField bankNameTextField, cardNameTextField, cardNumberTextField, expireDateTextfield, expireMonthTextField, ccvTextField;

    private Controller parentController;
    private ShoppingItem product;

    public paymentStepTwo(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/paymentStepTwo.fxml"));
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
