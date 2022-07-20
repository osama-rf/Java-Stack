public class GoriilaTest {
    public static void main(String[] args) {
        Gorilla g1 = new Gorilla();
        System.out.println(g1.getEnergyLevel());
        System.out.println(g1.displayEnergy());

        g1.throwSomething();
        g1.throwSomething();
        g1.throwSomething();

        g1.eatBananas();
        g1.eatBananas();

        g1.climb();

        g1.displayEnergy();
    }
}