package Views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class paymentStepOne extends AnchorPane {

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
}
