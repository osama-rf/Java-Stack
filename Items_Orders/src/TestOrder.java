public class TestOrder {
    public static void main(String[] args) {
               // Menu Items
        Items items1 = new Items();
        items1.name = "Drip";
        items1.price = 10.0;

        Items items2 = new Items();
        items2.name = "Latte";
        items2.price = 5.0;


        Items items3 = new Items();
        items3.name = "Capp";
        items3.price = 13.5;

        Items items4 = new Items();
        items4.name = "Mocha";
        items4.price = 15.2;

        // Orders
        Order order1 = new Order();
        order1.name = "Cindhuri";
        order1.total = items1.price;
        order1.ready = true;
        order1.items.add(items1);

        Order order2 = new Order();
        order1.name = "Jimmy";
        order2.total = items2.price;
        order2.ready = false;
        order2.items.add(items2);

        Order order3 = new Order();
        order3.name = "Noah";
        order3.total = items3.price;
        order3.ready = false;
        order3.items.add(items3);

        Order order4 = new Order();
        order4.name = "Sam";
        order4.total = items4.price;
        order4.ready = false;
        order4.items.add(items4);
        order4.items.add(items2);



        // Test

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Item name: %s\n", order1.items.get(0).name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
