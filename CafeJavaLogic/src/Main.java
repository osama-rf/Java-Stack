import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        CafeUtil coffeeApp = new CafeUtil();
        int reward = coffeeApp.getStreakGoal();
        System.out.println(reward);
        double[] prices = {12.5, 9.0, 4.5, 8.0, 10,0};
        double total = coffeeApp.getOrderTotal(prices);
        System.out.println(total);
        ArrayList<String> items = new ArrayList<String>();
        items.add("Drip");
        items.add("Latte");
        items.add("Tea");
        coffeeApp.displayMenu(items);
        ArrayList<String> customers = new ArrayList<String>();
        customers.add("Osama");
        customers.add("Aymen");
        customers.add("Anas");
    }
}