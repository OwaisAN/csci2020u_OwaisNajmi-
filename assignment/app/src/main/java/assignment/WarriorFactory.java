package assignment;

public class WarriorFactory {
    // The getWarrior method will be used to get any object of type Warrior
    // it will take in a String as a parameter and will return the corresponding object
    public Warrior getWarrior(String warrior){
        if (null == warrior) {
            return null;
        }else if ("berserker" == warrior) {
            return new Berserker();

        }else if ("gunlancer" == warrior){
            return new GunLancer();

        }else if ("Paladin" == warrior){
            return new Paladin();
            
        }else if ("Destroyer" == warrior){
            return new Destroyer();
        }

        return null;
    }
}




