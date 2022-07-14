public class Bat extends Mammal {

    public void fly(){
        int take = getEnergyLevel();
        take -= 50;
        setEnergyLevel(take);
        System.out.println("Sound a bat taking off and decrease its energy to: " + take);
    }

    public void eatHumans(){
        int eat = getEnergyLevel();
        eat += 25;
        setEnergyLevel(eat);
        System.out.println("The so- well, never mind, just increase its energy to: " + eat);
    }

    public void attackTown(){
        int attack = getEnergyLevel();
        attack -= 100;
        setEnergyLevel(attack);
        System.out.println("sound of a town on fire and decrease its energy to: " + attack);
    }


    @Override
    public int displayEnergy() {
        return super.displayEnergy();
    }
}
