package Views;

import Controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ShoppingItem;

import java.awt.*;
import java.io.IOException;

public class areYouSureDeleteSavedInfo extends AnchorPane {
    //fxid TILL AreYouSureDeleteSavedInfo
    @FXML private AnchorPane areYouSureTakeAwaySavedTasksPane;
    @FXML private ImageView areYouSureCrossImage;
    @FXML private Label areYouSureLabel;
    @FXML private javafx.scene.control.Button areYouSureYesButton;
    @FXML private javafx.scene.control.Button areYouSureCancelButton;
    @FXML private javafx.scene.control.Button areYouSureNoButton;

    private Controller parentController;
    private ShoppingItem product;

    public areYouSureDeleteSavedInfo(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/areYouSureDeleteSaveInfo.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = new ShoppingItem(product);
        this.parentController = controller;

        areYouSureYesButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                parentController.removeCustomerInfo();
            }
        });

        areYouSureNoButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                parentController.closeAreYouSureDeleteView();
            }
        });


        areYouSureCancelButton.defaultButtonProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                parentController.closeAreYouSureDeleteView();
            }
        });



    }


}
