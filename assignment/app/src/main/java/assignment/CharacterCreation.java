package assignment;

public class CharacterCreation {
    public static void main(String[] args) {
        // Creates an instance of WarriorFactory which has the getWarrior() method
        WarriorFactory warriorFactory = new WarriorFactory();

        // warriorFactory uses getWarrior() method and returns a Paladin class
        // the Paladin class is then assigned to warrior1
        Warrior warrior1 = warriorFactory.getWarrior("Paladin");

        // showClassInfo prints certain information depending on what class warrior1 is
        warrior1.showClassInfo();
    }
}


