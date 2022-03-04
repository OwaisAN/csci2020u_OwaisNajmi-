package assignment;

public class Berserker implements Warrior {
    // showClassInfo implemented from Warrior interface and overriden
    // prints information about the Warrior subclass that is different from all other subclasses
    @Override
    public void showClassInfo(){
        System.out.println("SubClassName: Berserker");
        System.out.println("Role: Damage");
        System.out.println("Weapon: Greatsword");
        System.out.println("Armor Type: Heavy");
        System.out.println("Combat Style: Melee");
    }
}



