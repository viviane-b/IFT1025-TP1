package ca.udem.ift1025.tp1.corrige;

public class Bank {
    private double gold;
    private int armour;

    public Bank(double gold, int armour) {
        this.gold = gold;
        this.armour = armour;
    }

    public double getGold() {return gold;}

    public int getArmour() {return armour;}

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public boolean isEmpty(){    //mettre les bons arguments
        if () {
            System.out.println("-Il vous manque de l'argent et/ou des armures pour améliorer Rogue.");
                                // il faut avoir une facon de rajouter le mot "Erreur:" avant les erreurs
                                // sans le mettre dans chaque message d'erreur sinon il peut apparaitre plusieurs fois
            return true;
        } else { return false; }

    }
}
