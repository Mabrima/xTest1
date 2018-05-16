import Controller.Controller;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

public class productGridItem extends Node {

    @FXML private Label itemLabel;
    @FXML private Label priceItem;
    @FXML private Label amountItemProductView;
    @FXML private ImageView imageItem;
    @FXML private ImageView minusItem;
    @FXML private ImageView plusItem;

    IMatDataHandler imatdatahandler;


    private Controller parentController;
    private Product product;

    public productGridItem(Product product, Controller parentController){
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("product"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        this.product= product;
        this.parentController=parentController;

        imageItem.setImage(imatdatahandler.getFXImage(product));

        itemLabel.setText(this.product.getName());


        priceItem.setText(this.product.getPrice()+ "st");        //kanske inte ska ha plus st då vi kanske även säljer kr/kg?
    }

    @Override
    protected NGNode impl_createPeer() {
        return null;
    }

    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
        return null;
    }

    @Override
    protected boolean impl_computeContains(double localX, double localY) {
        return false;
    }

    @Override
    public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
        return null;
    }
}


