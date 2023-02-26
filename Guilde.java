package ca.udem.ift1025.tp1.corrige;

public class Guilde {

    int montantInitial;
    int nbArmures;

    public Guilde(int montantInitial, int nbArmures) {
        this.montantInitial=montantInitial;
        this.nbArmures=nbArmures;

    }
    // mettre montant initial et armures dans la banque


    public void buyArmure(int boughtArmour, int unitaryCost) {
        //verifier qu'il y a assez d'argent dans la banque

        nbArmures+=boughtArmour;
        montantInitial-= unitaryCost*boughtArmour;
    }



}
