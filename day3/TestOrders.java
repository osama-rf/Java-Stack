import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args) {

        //inisializing CoffeeKiosk object
        CoffeeKiosk coffeKiosk = new CoffeeKiosk();
        coffeKiosk.addMenuItem("mocha", 3.25);
        coffeKiosk.addMenuItem("latte", 4.5);
        coffeKiosk.addMenuItem("drip coffee", 2.15);
        coffeKiosk.addMenuItem("capuccino", 3.5);
        coffeKiosk.displayMenu();
        coffeKiosk.newOrder();
    }
    
}