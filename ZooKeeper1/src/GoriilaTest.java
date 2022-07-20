public class GoriilaTest {
    public static void main(String[] args) {
        Gorilla g1 = new Gorilla();
        System.out.println(g1.getEnergyLevel());

        g1.throwSomething();
        g1.throwSomething();
        g1.throwSomething();

        g1.eatBananas();
        g1.eatBananas();

        g1.climb();
    }
}