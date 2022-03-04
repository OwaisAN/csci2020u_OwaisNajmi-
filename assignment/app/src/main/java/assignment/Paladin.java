package assignment;

public class Paladin implements Warrior {
    // showClassInfo implemented from Warrior interface and overriden
    // prints information about the Warrior subclass that is different from all other subclasses
    @Override
    public void showClassInfo(){
        System.out.println("SubClassName: Paladin");
        System.out.println("Role: Support");
        System.out.println("Weapon: Sword and Spellbook");
        System.out.println("Armor Type: Medium");
        System.out.println("Combat Style: Melee and Ranged");
    }
}



