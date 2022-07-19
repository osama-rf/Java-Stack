public class BaristaTest {
    public static void main(String[] args) {

        // Menu items
        Items item1 = new Items("cappucino", 5.5);
        Items item2 = new Items("Mocha", 6.5);
        Items item3 = new Items("Latte", 4.5);
        Items item4 = new Items("Drip Coffee", 5.0);

        //Create 2 orders for unspecified guests (without specifying a name);
        Orders order1 = new Orders();
        Orders order2 = new Orders();
        //Create 3 orders using the overloaded constructor to give each a name for the order.
        Orders order3 = new Orders("Anna");
        Orders order4 = new Orders("Emilie");
        Orders order5 = new Orders("Coco");
        //Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        order1.addItem(item1);
        order1.addItem(item4);
        //Implement the getStatusMessage method within the Order class
        System.out.println(order1.getStatusMessage());
        //Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());
        order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        //Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
        System.out.println(order1.getOrderTotal());

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);
        order3.display();



    }
}