public class Gorilla extends Mammal{

    public void  throwSomething(){
        int damage = getEnergyLevel();
        damage -= 5;
        setEnergyLevel(damage);
        System.out.println("The gorilla has throw something energy: " + damage);
    }

    public void eatBananas(){
        int sats = getEnergyLevel();
        sats += 10;
        setEnergyLevel(sats);
        System.out.println("The gorilla's satisfaction and increase its energy to: " + sats);
    }

    public void climb(){
        int tired = getEnergyLevel();
        tired -= 10;
        setEnergyLevel(tired);
        System.out.println("The gorilla has climbed a tree and decrease its energy to: " + tired);
    }
}
