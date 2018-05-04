import se.chalmers.cse.dat216.project.*;

import java.util.Date;
import java.util.List;

public class CustomList {
    List<ShoppingItem> items;
    Date date;

    public CustomList(Date date, List<ShoppingItem> items){
        this.date = date;
        this.items = items;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ShoppingItem> getItems() {
        return this.items;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }

    //TODO plus minus through the similar to the cart I guess (probably in the controller)


}
