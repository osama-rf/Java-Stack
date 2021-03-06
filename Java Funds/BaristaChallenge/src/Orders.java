import java.util.ArrayList;

    // Here we're creating a new data type called Order
public class Orders {

    // MEMBER VARIABLES
    private String name;
    private boolean ready;
    private ArrayList<Items> items = new ArrayList<Items>();

        // CONSTRUCTOR

    public Orders() {
        this.name = "Guest";
    }
        // OVERLOADED CONSTRUCTOR
    public Orders(String name){
        this.name = name;
    }

        // ORDER METHODS
    public void addItem(Items items1){
        this.items.add(items1);
    }

    public boolean getStatusMessage(){
        if(this.ready == true){
            System.out.println("Your order is ready.");
        } else {
            System.out.println("Thank you for waiting. Your order will be ready soon.");
        }
        return false;
    }

//    public double getOrderTotal(){
//        double sum = 0.0;
//        for(int i = 0; i < items.size(); i++){
//            sum += items.get(i).price;
//        }
//        return sum;
//    }
    public double getOrderTotal(){
        double sum = 0.0;
        for(Items i : this.items){
            sum += i.getPrice();
        }
        return sum;
    }

    public void display(){
        System.out.printf("Customer Name: %s", this.name);
        for(Items i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }





        // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
