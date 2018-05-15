import se.chalmers.cse.dat216.project.*;

import java.util.Date;
import java.util.List;

public class CustomList {
    List<ShoppingItem> items;

    public CustomList(){
    }

    public List<ShoppingItem> getItems() {
        return this.items;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }

    //TODO plus minus through the similar to the cart I guess (probably in the controller) Don't bother for now


}
