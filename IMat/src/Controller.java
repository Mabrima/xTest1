import se.chalmers.cse.dat216.project.*;

public class Controller {


    //För att demonstrera hur dataHandlern kommer fungera
    public void test(){
        IMatDataHandler dataHandler = IMatDataHandler.getInstance();
        dataHandler.findProducts("type");

    }


}
