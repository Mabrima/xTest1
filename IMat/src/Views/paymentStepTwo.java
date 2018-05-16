package Views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class paymentStepTwo extends AnchorPane {

    //fxid TILL PaymentStepTwo
    @FXML
    private AnchorPane paymentStepTwoAnchorPane;
    @FXML
    private Button backToPaymentStepOne, completePaymentButton, deleteMyCardInfoButton, changeMyCardInfoButton, continueShoppingButtonPaymentStepTwo;
    @FXML
    private TextField bankNameTextField, cardNameTextField, cardNumberTextField, expireDateTextfield, expireMonthTextField, ccvTextField;

}
