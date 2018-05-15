import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

public class cartList extends AnchorPane {

    private Controller parentController;
    private Product foodProduct;

    public cartList(Product foodProduct, Controller parentController){
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource(""));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        this.foodProduct= foodProduct;
        this.parentController=parentController;
    }
}
