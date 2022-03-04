package assignment;

public class GunLancer implements Warrior {

    // showClassInfo implemented from Warrior interface and overriden
    // prints information about the Warrior subclass that is different from all other subclasses
    @Override
    public void showClassInfo(){
        System.out.println("SubClassName: Gunlancer");
        System.out.println("Role: Tank");
        System.out.println("Weapon: Gunlance and Greatsheild");
        System.out.println("Armor Type: Heavy");
        System.out.println("Combat Style: Semi-ranged");
    }
}

